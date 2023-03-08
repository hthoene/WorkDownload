package work.download.storage;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.AesKeyStrength;
import net.lingala.zip4j.model.enums.CompressionLevel;
import net.lingala.zip4j.model.enums.EncryptionMethod;
import org.apache.commons.lang3.SystemUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import work.download.appuser.AppUser;
import work.download.appuser.dto.UserStorageDto;
import work.download.delivery.Delivery;
import work.download.deliveryfile.exceptions.DeliveryFileException;
import work.download.deliveryfile.exceptions.DeliveryFileExceptionType;
import work.download.utils.GlobalConfig;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class FilesStorageService {

    private static List<Path> storageSpaces;

    private static String profilePictureLocation;

    private GlobalConfig config;

    private static int freeGbRequirement = 10;

    public FilesStorageService(GlobalConfig config) {
        this.config = config;

        String mode = config.getMode();

        storageSpaces = new ArrayList<>();





        if(SystemUtils.IS_OS_LINUX) {

            profilePictureLocation = "/home/workdownload/profilePictures";
            storageSpaces.add(Path.of("/home/workdownload/files"));
            storageSpaces.add(Path.of("/mnt/work/workdownload"));

            FileSystem fs = FileSystems.getDefault();

            for (FileStore fileStore : fs.getFileStores()) {
                try {
                    System.out.println(fileStore.name() + " => USABLE => " + getReadableFileSize(fileStore.getUsableSpace()) + " => TOTAL => " + getReadableFileSize(fileStore.getTotalSpace()));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }


        } else {

            profilePictureLocation = "C:/Users/thoen/Downloads/profilePictures";
            storageSpaces.add(Path.of("C:/Users/thoen/Downloads/workdownload"));

        }



    }


    public static List<Path> getStorageSpaces() {

        return storageSpaces;
    }

    public long getTotalStorageUsed() {

        long total = 0;

        try {
            for(Path path : storageSpaces) {
                File folder = path.toFile();
                File[] files = folder.listFiles();
                for(File file : files) {
                    if(file.isFile()) {
                        total += Files.size(file.toPath());
                    }
                }
            }

        } catch(IOException exception) {
            exception.printStackTrace();
        }


        return total;

    }

    public long getDiskSpaceUsed() {

        long total = 0;

        for(Path path : storageSpaces) {

            File file;
            if(SystemUtils.IS_OS_LINUX) {
                file = new File("/" + path.toString().split("/")[1]);
            } else {
                file = new File(path.toString().split("/")[0]);
            }

            total += (file.getTotalSpace() - file.getUsableSpace());
        }

        return total;
    }


    public long getTotalStorage() {

        long total = 0;

        for(Path path : storageSpaces) {

            File file = path.toFile();
            total += file.getTotalSpace();
        }

        return total;

    }

    public long getFreeStorageLeft() {
        long total = 0;

        for(Path path : storageSpaces) {

            File file = path.toFile();
            total += file.getUsableSpace();
        }

        return total;
    }
// // RANDOM
//    private Path getFreePath() {
//
//        long usableSpace = 0;
//
//        Path path = null;
//
//        while(usableSpace <= freeGbRequirement) {
//            int randomInt = ThreadLocalRandom.current().nextInt(0, storageSpaces.size());
//            path = storageSpaces.get(randomInt);
//
//            File tempFile = new File(path + "/storageLocation");
//
//            try {
//                Files.createDirectories(path);
//                tempFile.createNewFile();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//
//            usableSpace = tempFile.getUsableSpace() / 1000 / 1000 / 1000;
//        }
//
//        return path;
//    }

    private Path getFreePath() {

        long usableSpace = 0;

        Path path = null;

        int counter = 0;

        while(usableSpace <= freeGbRequirement) {

            path = storageSpaces.get(counter);

            counter++;

            File tempFile = new File(path + "/storageLocation");

            try {
                Files.createDirectories(path);
                tempFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            usableSpace = tempFile.getUsableSpace() / 1000 / 1000 / 1000;
        }

        return path;
    }

    public boolean saveInFolder(MultipartFile file, Delivery delivery, String folder) {
        if(folder.startsWith("/")) {
            folder = folder.substring(1);
        }

        if(folder.endsWith("/")) {



            folder = folder.substring(0, folder.length() - 1);


            System.out.println("FOLDER FROM CIENT: " + folder);
        }


        Path folderPath = Paths.get(delivery.getDiskPath() + "/" + folder);

        Path filePath = Paths.get(folderPath + "/" + file.getOriginalFilename());

        ZipFile zipFile = new ZipFile(delivery.getDiskPath() + ".zip", delivery.getPassword().toCharArray());




        try {

            if(zipFile.getFileHeader(folder + "/" + file.getOriginalFilename()) != null) {
                zipFile.close();
                throw new DeliveryFileException("File already exists", DeliveryFileExceptionType.FILE_ALREADY_EXISTS);
            }

            Files.createDirectories(folderPath);



            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);


            ZipParameters zipParameters = new ZipParameters();

            String fileNameInZip = folder + "/" + filePath.getFileName();

            if(fileNameInZip.startsWith("/")) {
                fileNameInZip = fileNameInZip.substring(1);
            }
            System.out.println("Filename: " + fileNameInZip);

            zipParameters.setFileNameInZip(fileNameInZip);

            // Encryption
            zipParameters.setEncryptFiles(true);
            zipParameters.setCompressionLevel(CompressionLevel.HIGHER);
            zipParameters.setEncryptionMethod(EncryptionMethod.AES);
            zipParameters.setAesKeyStrength(AesKeyStrength.KEY_STRENGTH_128);


            zipFile.addFile(new File(filePath.toString()), zipParameters);

            zipFile.close();

            File deleteFile = new File(filePath.toString());
            deleteFile.delete();

            return true;
        } catch (Exception e) {
            e.printStackTrace();

            try {
                zipFile.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        } finally {
            try {
                zipFile.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void deleteDir(File file) {
        File[] contents = file.listFiles();
        if (contents != null) {
            for (File f : contents) {
                deleteDir(f);
            }
        }
        file.delete();
    }

    public Path getFolderPathByDeliveryAndFolder(Delivery delivery, String folder) {
        if(folder.contains("..")) {
            throw new IllegalArgumentException("Illegal action");
        }
        return Path.of(delivery.getDiskPath() + "/" + folder);
    }

    public Path saveProfilePicture(AppUser appUser, MultipartFile file) {
        try {
            Path folderPath = Paths.get(profilePictureLocation + "/" + appUser.getId());
            Files.createDirectories(folderPath);
            File folderFile = new File(folderPath.toString());
            if(folderFile.listFiles().length <= 1) {
                Arrays.stream(folderFile.listFiles()).forEach(f -> f.delete());
            }
            Path filePath = Paths.get(folderPath + "/" + file.getOriginalFilename());
            Files.copy(file.getInputStream(), filePath);

            return filePath;
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }

    public Path createPathWithId(String id) {

        try {
            Path folderPath = Paths.get(getFreePath().toString() + "/" + id + "/");
            return Files.createDirectories(folderPath);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Resource load(Path path) {
        try {
            Resource resource = new UrlResource(path.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }


    public boolean extractFile(Delivery delivery, String localPath) {

        if(localPath.startsWith("/")) {
            localPath = localPath.substring(1);
        }

        ZipFile zipFile = new ZipFile(delivery.getDiskPath() + ".zip", delivery.getPassword().toCharArray());
        try {
            FileHeader fileHeader = zipFile.getFileHeader(localPath);
            if(fileHeader == null) return false;

            zipFile.extractFile(fileHeader, delivery.getDiskPath());
            zipFile.close();

        } catch (ZipException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                zipFile.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return true;
    }

    public boolean extractFolder(Delivery delivery, String localPath) {

        localPath = unifyLocalFolderPath(localPath);

        File folder = new File(delivery.getDiskPath() + "/" + localPath);

        ZipFile zipFile = new ZipFile(delivery.getDiskPath() + ".zip", delivery.getPassword().toCharArray());

        boolean hasFile = false;

        try {
            for(FileHeader f : zipFile.getFileHeaders()) {
                if(f.getFileName().startsWith(localPath)) {
                    hasFile = true;
                    break;
                }
            }
        } catch (ZipException e) {
            throw new RuntimeException(e);
        }


        if(folder.isFile() || !hasFile) {
            return false;
        }

        try {

            String expLocation = delivery.getDiskPath() + "/" + "exp_dir";

            zipFile.extractAll(expLocation);

            zipFile.close();

            zipFile = new ZipFile(expLocation + ".zip");
            zipFile.addFolder(new File(expLocation + "/" + localPath));

            zipFile.close();

            deleteDir(new File(expLocation));

            return true;

        } catch (ZipException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                zipFile.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return true;

    }

    private boolean deleteTempFolder(Delivery delivery) {
        deleteDir(new File(delivery.getDiskPath()));
        return true;
    }

    public boolean delete(Delivery delivery, String localPath) {

        if(localPath.startsWith("/")) {
            localPath = localPath.substring(1);
        }

        ZipFile zipFile = new ZipFile(delivery.getDiskPath() + ".zip", delivery.getPassword().toCharArray());

        try {
            FileHeader fileHeader = zipFile.getFileHeader(localPath);
            if(fileHeader != null) {
                zipFile.removeFile(fileHeader);
            }

            deleteAllFilesFromZipFolder(zipFile, localPath);
            File file = new File(delivery.getDiskPath() + "/" + localPath);
            if(file.isDirectory()) {
                deleteDir(file);
            }
            if(file.exists()) {
                Files.delete(Path.of(file.getAbsolutePath()));
            }
        } catch (ZipException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                zipFile.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return true;
    }

    public boolean renameFile(Delivery delivery, String localPath, String newName) {

        if(newName.contains("/") || newName.contains("\\")) {
            throw new DeliveryFileException("Illegal character", DeliveryFileExceptionType.FILE_ALREADY_EXISTS);
        }

        localPath = localPath.replace("//", "/");
        if(localPath.contains("//")) {
            throw new DeliveryFileException("Something went wrong", DeliveryFileExceptionType.FILE_ALREADY_EXISTS);
        }

        if(localPath.startsWith("/")) {
            localPath = localPath.substring(1);
        }

        if(localPath.endsWith("/")) {
            localPath = localPath.substring(0, localPath.length() - 1);
        }

        ZipFile zipFile = new ZipFile(delivery.getDiskPath() + ".zip", delivery.getPassword().toCharArray());

        File file = new File(delivery.getDiskPath() + "/" + localPath);

        if(file.isDirectory()) {


            // FILE IS A FOLDER
            System.out.println("is folder");


            int renameAt = countSlash(localPath);
            List<String> localPathAsList = getPathAsFolderNameList(localPath);
            String folderNameToRename = localPathAsList.get(localPathAsList.size() - 1);

            System.out.println("Renaming folder: " + localPath);



            // TODO: rename folders

            try {
                List<FileHeader> fileHeaders = zipFile.getFileHeaders();

                String finalLocalPath = localPath;
                fileHeaders.forEach(h -> {
                    String header = h.toString();

                    if(countSlash(header) < renameAt) return;

                    List<String> pathAsList = getPathAsFolderNameList(header);

                    if(!pathAsList.get(renameAt).equals(folderNameToRename)) return;

                    pathAsList.set(renameAt, newName);

                    String newPath = mergeFolderListToString(pathAsList);



                    try {

                        System.out.println("File searching: " + zipFile.getFileHeader(newPath));

                        System.out.println("Files existing: ");
                        zipFile.getFileHeaders().forEach(System.out::println);

                        if(zipFile.getFileHeaders().contains(zipFile.getFileHeader(newPath))) {
                            throw new DeliveryFileException("File with this name already exists", DeliveryFileExceptionType.FILE_ALREADY_EXISTS);
                        }
                        zipFile.renameFile(header, newPath);
                    } catch (ZipException e) {
                        throw new RuntimeException(e);
                    }

                });

                File renamedFile = new File(delivery.getDiskPath() + "/" + cutFileName(finalLocalPath) + "/" + newName);

                file.renameTo(renamedFile);



            } catch (ZipException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    zipFile.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }


        } else {
            // FILE IS A FILE

            System.out.println("is folder");

            try {

                System.out.println("LOCAL PATH: " + localPath);

                FileHeader fileHeader = zipFile.getFileHeader(localPath);

                if(fileHeader == null) {
                    zipFile.close();
                    return false;
                }

                String renameTo = cutFileName(fileHeader.toString()) + newName;

                System.out.println("Renaming to: " + renameTo);

                if(zipFile.getFileHeader(renameTo) != null) {
                    zipFile.close();
                    throw new DeliveryFileException("File already exists", DeliveryFileExceptionType.FILE_ALREADY_EXISTS);
                }

                zipFile.renameFile(fileHeader, renameTo);
                zipFile.close();
            } catch (ZipException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    zipFile.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }


        }


        return true;
    }

    public boolean cleanDecryptedFiles(Delivery delivery) {

        File file = new File(delivery.getDiskPath() + "/");

        File zipExpFile = new File(delivery.getDiskPath() + "/exp_dir.zip");

        try {
            if(zipExpFile.exists()) {
                Files.delete(zipExpFile.toPath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Files.walk(Paths.get(file.getAbsolutePath()))
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .forEach(File::delete);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return true;

    }

    private boolean deleteAllFilesFromZipFolder(ZipFile zipFile, String folderPath) {

        if(!folderPath.startsWith("/")) {
            folderPath += "/";
        }

        try {
            List<FileHeader> fileHeaders = zipFile.getFileHeaders().stream().toList();

            String finalFolderPath = folderPath;
            fileHeaders.forEach(h -> {
                String header = h.toString();

                if(header.startsWith(finalFolderPath)) {
                    try {
                        zipFile.removeFile(h);
                    } catch (ZipException e) {
                        throw new RuntimeException(e);
                    } finally {
                        try {
                            zipFile.close();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }


            });


        } catch (ZipException e) {
            throw new RuntimeException(e);
        }
return true;

    }

    public boolean deleteFolder(Delivery delivery, String localPath) {

        localPath = unifyLocalFolderPath(localPath);

        ZipFile zipFile = new ZipFile(delivery.getDiskPath() + ".zip", delivery.getPassword().toCharArray());

        File folder = new File(delivery.getDiskPath() + "/" + localPath);

        if(folder.isDirectory()) {
            deleteDir(folder);
        }

        if(zipFile == null) return true;

        List<FileHeader> headers;
        try {
            headers = zipFile.getFileHeaders().stream().collect(Collectors.toList());
        } catch (ZipException e) {
            throw new RuntimeException(e);
        }

        if(headers == null) return true;

        for(FileHeader f : headers) {
            if(f.getFileName().startsWith(localPath)) {
                try {
                    zipFile.removeFile(f);
                } catch (ZipException e) {
                    e.printStackTrace();
                }
            }
        }

        try {
            zipFile.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;

    }

    public List<File> getAllFiles(File folder) {

        File[] listOfFiles = folder.listFiles();

        List<File> files = new ArrayList<>();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                files.add(listOfFiles[i]);
            }
        }

        return files;

    }

    public List<File> getAllFolders(File folder) {

        File[] listOfFolders = folder.listFiles();


        List<File> folders = new ArrayList<>();

        for (int i = 0; i < listOfFolders.length; i++) {
            if (listOfFolders[i].isDirectory()) {
                folders.add(listOfFolders[i]);
            }
        }

        return folders;

    }

    private int countSlash(String value) {
        return (int) value.chars().filter(ch -> ch == '/').count();
    }


    private int getFileNameChars(String fileName) {
        String[] split = fileName.split("/");
        return split[split.length - 1].length();
    }

    private List<String> getPathAsFolderNameList(String path) {
        if(path.startsWith("/")) {
            path = path.substring(1);
        }
        if(path.endsWith("/")) {
            path = path.substring(0, path.length() - 1);
        }

        String[] split = path.split("/");

        List<String> newList = new ArrayList<>();

        newList.addAll(Arrays.stream(split).toList());

        return newList;


    }

    private String unifyLocalFolderPath(String path) {
        if(path.startsWith("/")) {
            path = path.substring(1);
        }
        if(path.endsWith("/")) {
            path = path.substring(0, path.length() - 1);
        }
        path = path.replace("//", "/");
        if(path.contains("..")) {
            throw new IllegalStateException();
        }
        if(path.contains("//")) {
            throw new DeliveryFileException("Something went wrong", DeliveryFileExceptionType.FILE_ALREADY_EXISTS);
        }
        return path;
    }

    private String mergeFolderListToString(List<String> list) {

        return String.join("/", list);

    }

    public String getReadableFileSize(long size) {
        if (size <= 0) {
            return "0";
        }
        final String[] units = new String[] { "B", "KB", "MB", "GB", "TB" };
        int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
        return new DecimalFormat("#,##0.#").format(size / Math.pow(1024, digitGroups)) + " " + units[digitGroups];
    }

    private String getFileName(String path) {
        String[] split = path.split("/");
        String name = split[split.length - 1];
        if(name.startsWith("/")) {
            name = name.substring(1);
        }
        if(name.endsWith("/")) {
            name = name.substring(0, name.length() - 1);
        }
        return name;
    }

    private String cutFileName(String path) {
        return path.substring(0, path.length() - getFileNameChars(path));
    }

    public UserStorageDto getUserStorageDto(AppUser appUser) {

        long totalStorageUsed = 0;

        List<Delivery> deliveries = appUser.getDeliveries();
        for(Delivery delivery : deliveries) {
            ZipFile zipFile = new ZipFile(delivery.getDiskPath() + ".zip", delivery.getPassword().toCharArray());
            if(zipFile == null) continue;
            try {
                for(FileHeader zipHeader : zipFile.getFileHeaders()) {
                    totalStorageUsed += zipHeader.getUncompressedSize();
                }
            } catch (ZipException e) {
                throw new RuntimeException(e);
            }
        }

        UserStorageDto storageDto = new UserStorageDto();
        storageDto.setUsedStorage(totalStorageUsed);
        storageDto.setUsedStorageText(getReadableFileSize(totalStorageUsed));

        storageDto.setTotalStorageAvailable(appUser.getStorage());
        storageDto.setTotalStorageAvailableText(getReadableFileSize(appUser.getStorage()));

        return storageDto;

    }

    public void deleteDelivery(Delivery delivery) {
        File zipFile = new File(delivery.getDiskPath() + ".zip");
        File folderFile = new File(delivery.getDiskPath());
        if(zipFile.exists()) {
            try {
                Files.delete(zipFile.toPath());
            }catch (IOException ex) {

            }
        }
        if(folderFile.exists() && folderFile.isDirectory()) {
            deleteDir(folderFile);
        }
    }

    public void updatePassword(Delivery delivery, String password) {
        ZipFile zipFile = new ZipFile(delivery.getDiskPath() + ".zip", delivery.getPassword().toCharArray());

        if(!zipFile.getFile().exists()) return;

        try {

            ZipParameters zipParameters = new ZipParameters();

            // Encryption
            zipParameters.setEncryptFiles(true);
            zipParameters.setCompressionLevel(CompressionLevel.HIGHER);
            zipParameters.setEncryptionMethod(EncryptionMethod.AES);
            zipParameters.setAesKeyStrength(AesKeyStrength.KEY_STRENGTH_128);

            ZipFile newZipFile = new ZipFile(delivery.getDiskPath() + "_temp.zip", password.toCharArray());

            List<FileHeader> fileHeaders = zipFile.getFileHeaders().stream().toList();

            for (FileHeader fileHeader : fileHeaders) {
                zipFile.extractFile(fileHeader.getFileName(), delivery.getDiskPath() + "_temp/");
                zipParameters.setFileNameInZip(fileHeader.getFileName());
                newZipFile.addFile(new File(delivery.getDiskPath() + "_temp/" + fileHeader.getFileName()), zipParameters);
            }

            zipFile.close();
            newZipFile.close();
             File file = new File(delivery.getDiskPath() + ".zip");
             Files.delete(file.toPath());

             File file2 = new File(delivery.getDiskPath() + "_temp.zip");
             Files.move(file2.toPath(), file2.toPath().resolveSibling(delivery.getDiskPath() + ".zip"));
             File tempFolder = new File(delivery.getDiskPath() + "_temp");
             deleteDir(tempFolder);

        } catch (ZipException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}