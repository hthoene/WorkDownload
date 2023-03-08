package work.download.deliveryfile;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import work.download.appuser.AppUser;
import work.download.delivery.Delivery;
import work.download.delivery.DeliveryRepository;
import work.download.delivery.DeliveryService;
import work.download.deliveryfile.exceptions.DeliveryFileException;
import work.download.deliveryfile.exceptions.DeliveryFileExceptionType;
import work.download.storage.FilesStorageService;

import java.io.File;
import java.util.*;

@Service
public class DeliveryFileService {

    private final FilesStorageService storageService;
    private final DeliveryRepository deliveryRepository;

    private DeliveryService deliveryService;

    public DeliveryFileService(FilesStorageService storageService, DeliveryRepository deliveryRepository, DeliveryService deliveryService) {
        this.storageService = storageService;
        this.deliveryRepository = deliveryRepository;
        this.deliveryService = deliveryService;
    }

    public void saveInFolder(MultipartFile[] files, Long deliveryId, String folder, AppUser appUser) {

        Delivery delivery = deliveryService.getByIdAndUser(deliveryId, appUser);

        try {
            Arrays.asList(files).stream().forEach(file -> {
                storageService.saveInFolder(file, delivery, folder);
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DeliveryFileException("A file with this name already exists", DeliveryFileExceptionType.FILE_ALREADY_EXISTS);
        }
    }


    public List<FileDto> getAllFiles(FileLocationRequest request) {

        Delivery delivery = deliveryService.getByDeliveryLogin(request);

        ZipFile zipFile = new ZipFile(delivery.getDiskPath() + ".zip", delivery.getPassword().toCharArray());

        if(zipFile == null) {
            return new ArrayList<>();
        }

        List<FileHeader> fileHeaders;

        try {
            fileHeaders = zipFile.getFileHeaders();
        } catch (ZipException e) {
            throw new RuntimeException(e);
        }

        String requestFolder = request.getLocalPath();
        if(!requestFolder.endsWith("/")) {
            requestFolder += "/";
        }
        if(requestFolder.startsWith("/")) {
            requestFolder = requestFolder.substring(1);
        }

        List<FileDto> files = new ArrayList<>();

        String finalRequestFolder = requestFolder;
        fileHeaders.forEach(header -> {

            System.out.println("header: " + header.toString());
            System.out.println("request: " + finalRequestFolder);

            if(countSlash(header.toString()) == countSlash(finalRequestFolder)) {
                if(header.toString().startsWith(finalRequestFolder)) {
                    FileDto data = new FileDto();

                    String fileName = header.getFileName();

                    if(fileName.contains("/")) {
                        fileName = header.getFileName().split("/")[countSlash(finalRequestFolder)];
                    }

                    data.setLocalPath(header.toString());

                    data.setFileName(fileName);


                    data.setSizeInBytes(header.getUncompressedSize());
                    files.add(data);
                }
            }
        });
        return files;


    }

    private int countSlash(String value) {
        return (int) value.chars().filter(ch -> ch == '/').count();
    }


    public List<FolderDto> getAllFolders(FileLocationRequest request) {

        Delivery delivery = deliveryService.getByDeliveryLogin(request);

        String requestPath = request.getLocalPath();

        if(requestPath.startsWith("/")) {
            requestPath = requestPath.substring(1);
        }

        File folder = new File(delivery.getDiskPath() + "/" + requestPath);

        File[] listOfFolders = folder.listFiles();

        if(listOfFolders == null) return new ArrayList<>();


        List<FolderDto> folders = new ArrayList<>();

        for (int i = 0; i < listOfFolders.length; i++) {
            if (listOfFolders[i].isDirectory()) {

                File file = listOfFolders[i];
                FolderDto data = new FolderDto();
                data.setFolderName(file.getName());
                data.setLocalPath(requestPath + "/" + file.getName());

                data.setFolderElements(getElementsAmount(delivery, requestPath));

                folders.add(data);
            }
        }

        return folders;




//        Delivery delivery = deliveryService.getByDeliveryLogin(request);
//
//        ZipFile zipFile = new ZipFile(delivery.getDiskPath() + ".zip", delivery.getPassword().toCharArray());
//
//        List<FileHeader> fileHeaders;
//
//        try {
//            fileHeaders = zipFile.getFileHeaders();
//            System.out.println("Headers");
//            fileHeaders.forEach(System.out::println);
//
//        } catch (ZipException e) {
//            throw new RuntimeException(e);
//        }
//
//        String requestFolder = request.getLocalPath();
//        if(!requestFolder.endsWith("/")) {
//            requestFolder += "/";
//        }
//        if(requestFolder.startsWith("/")) {
//            requestFolder = requestFolder.substring(1);
//        }
//
//        List<FolderDto> folders = new ArrayList<>();
//
//        String finalRequestFolder = requestFolder;
//
//        Set<String> allFolders = new HashSet<>();
//
//        fileHeaders.forEach(h -> {
//
//            String header = h.toString();
//
//            if(countSlash(header) < countSlash(finalRequestFolder)) return;
//
//            allFolders.add(cutFileName(header));
//
//        });
//
//        System.out.println("Request: " + requestFolder);
//
//        System.out.println(allFolders);
//
//        allFolders.forEach(folder -> {
//            if(folder.startsWith(finalRequestFolder)) {
//
//
//                String folderWorked = folder.replace(finalRequestFolder, "");
//
//                System.out.println("WORKED: " + folderWorked);
//
//                List<String> foldersFromString = getFoldersFromString(folder, countSlash(finalRequestFolder));
//
//                System.out.println("List: " + foldersFromString);
//
//
//
//                FolderDto data = new FolderDto();
//
//                data.setFolderName(foldersFromString.get(foldersFromString.size() - 1));
//                data.setLocalPath(StringUtils.join(foldersFromString, "/"));
//                data.setFolderElements(2);
//
//                if(foldersFromString.get(foldersFromString.size() - 1).isEmpty()) return;
//
//                if(folders.stream().filter(folderDto -> folderDto.getLocalPath().equals(data.getLocalPath())).collect(Collectors.toList()).size() < 1) {
//                    folders.add(data);
//                }
//
//
//
//
//
//            }
//        });
//
//
////        FolderDto data = new FolderDto();
////        data.setFolderName(pureFolder.split("/")[countSlash(pureFolder) - 1]);
////        data.setLocalPath(pureFolder.substring(0, pureFolder.length() - 1));
////        data.setFolderElements(1);
//
////        folders.add(data);
//
//
//
//
//
//
//        System.out.println(folders);


    }

    private int getElementsAmount(Delivery delivery, String localPath) {
        ZipFile zipFile = new ZipFile(delivery.getDiskPath() + ".zip", delivery.getPassword().toCharArray());
        int amount = 0;
        try {
            List<FileHeader> fileHeaders = zipFile.getFileHeaders();
            for(FileHeader header : fileHeaders) {
                if(header.toString().startsWith(localPath)) {
                    amount++;
                }
            }
        } catch (ZipException e) {
            throw new RuntimeException(e);
        }
        return amount;
    }

    private List<String> getFoldersFromString(String fullString, int deep) {
        String[] split = fullString.split("/");
        List<String> full = new ArrayList<>();
        for(int i = 0; i <= deep; i++) {
            full.add(split[i]);
        }
        return full;
    }

    private int getFileNameChars(String fileName) {
        String[] split = fileName.split("/");
        return split[split.length - 1].length();
    }

    private String cutFileName(String path) {
        return path.substring(0, path.length() - getFileNameChars(path));
    }


    public boolean createFolder(Delivery delivery, String localPath) {

        if(localPath.startsWith("/")) {
            localPath = localPath.substring(1);
        }

        String folderPath = delivery.getDiskPath() + "/" + localPath;

        File file = new File(folderPath);
        return file.mkdirs();

    }
}
