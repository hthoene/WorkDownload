package work.download.deliveryfile;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import work.download.appuser.AppUser;
import work.download.appuser.AppUserRepository;
import work.download.delivery.Delivery;
import work.download.delivery.DeliveryRepository;
import work.download.delivery.DeliveryService;
import work.download.deliveryfile.exceptions.DeliveryFileException;
import work.download.deliveryfile.exceptions.DeliveryFileExceptionType;
import work.download.responses.ResponseMessage;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import work.download.storage.FilesStorageService;
import work.download.utils.GlobalConfig;
import work.download.utils.MyInterceptor;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/file")
public class DeliveryFileController {

    private final FilesStorageService storageService;

    private final DeliveryService deliveryService;

    private final DeliveryFileService deliveryFileService;

    private final AppUserRepository appUserRepository;

    private final DeliveryRepository deliveryRepository;



    private final ModelMapper modelMapper;

    public DeliveryFileController(FilesStorageService storageService, DeliveryService deliveryService, DeliveryFileService deliveryFileService, AppUserRepository appUserRepository, DeliveryRepository deliveryRepository, ModelMapper modelMapper) {
        this.storageService = storageService;
        this.deliveryService = deliveryService;
        this.deliveryFileService = deliveryFileService;
        this.appUserRepository = appUserRepository;
        this.deliveryRepository = deliveryRepository;
        this.modelMapper = modelMapper;
    }

    @PostMapping("show/files")
    public ResponseEntity<List<FileDto>> showFiles(@RequestBody FileLocationRequest request) {
        List<FileDto> allFiles = deliveryFileService.getAllFiles(request);

        return new ResponseEntity(allFiles, HttpStatus.OK);
    }

    @PostMapping("show/folders")
    public ResponseEntity<List<FolderDto>> showFolders(@RequestBody FileLocationRequest request) {
        List<FolderDto> allFiles = deliveryFileService.getAllFolders(request);

        return new ResponseEntity(allFiles, HttpStatus.OK);
    }

    @PostMapping("createFolder")
    public ResponseEntity<ResponseMessage> createFolder(@RequestBody FileLocationRequest request, @AuthenticationPrincipal AppUser appUser) {
        Delivery delivery = deliveryService.getByIdAndUser(request.getDeliveryId(), appUser);
        deliveryFileService.createFolder(delivery, request.getLocalPath());

        return ResponseEntity.ok(new ResponseMessage("Success"));


    }

    @PostMapping("rename")
    public ResponseEntity<ResponseMessage> renameFile(@RequestBody FileRenameRequest request, @AuthenticationPrincipal AppUser appUser) {
        Delivery delivery = deliveryService.getByIdAndUser(request.getDeliveryId(), appUser);
        storageService.renameFile(delivery, request.getLocalPath(), request.getRenameTo());
        return ResponseEntity.ok(new ResponseMessage("Success"));


    }

    @PostMapping("downloadFolder")
    public ResponseEntity<Resource> downloadFolder(@RequestBody DownloadRequest downloadRequest) {

        Delivery delivery = deliveryService.getByIdAndPassword(downloadRequest.getDeliveryId(), downloadRequest.getPassword());

        delivery.setLastAccess(LocalDateTime.now());

        delivery = deliveryRepository.save(delivery);

        boolean fileExists = storageService.extractFolder(delivery, downloadRequest.getLocalPath());

        if(!fileExists) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        Resource file = storageService.load(Path.of(delivery.getDiskPath() + "/exp_dir.zip"));

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .header(MyInterceptor.TMP_RESOURCE_ID_HEADER, delivery.getId().toString())
                .body(file);
    }

    @PostMapping("download")
    public ResponseEntity<Resource> getFile(@RequestBody DownloadRequest downloadRequest) {

        Delivery delivery = deliveryService.getByIdAndPassword(downloadRequest.getDeliveryId(), downloadRequest.getPassword());

        delivery.setLastAccess(LocalDateTime.now());

        delivery = deliveryRepository.save(delivery);

        boolean fileExists = storageService.extractFile(delivery, downloadRequest.getLocalPath());

        System.out.println(fileExists);

        Resource file = storageService.load(Path.of(delivery.getDiskPath() + "/" + downloadRequest.getLocalPath()));

        MediaType mediaType;

        try {
            mediaType = MediaType.parseMediaType(Files.probeContentType(file.getFile().toPath()));
        } catch (Exception e) {
            mediaType = MediaType.APPLICATION_OCTET_STREAM;
        }

        if(mediaType == null) {
            mediaType = MediaType.APPLICATION_OCTET_STREAM;
        }

        return ResponseEntity.ok().contentType(mediaType)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .header(MyInterceptor.TMP_RESOURCE_ID_HEADER, delivery.getId().toString())
                .body(file);
    }

    @PostMapping("delete")
    public ResponseEntity<ResponseMessage> deleteFile(@RequestBody FileLocationRequest request, @AuthenticationPrincipal AppUser appUser)
    {
        deliveryService.deleteFile(request, appUser);
        return ResponseEntity.ok(new ResponseMessage("Success"));
    }

    @PostMapping("deleteFolder")
    public ResponseEntity<ResponseMessage> deleteFolder(@RequestBody FileLocationRequest request, @AuthenticationPrincipal AppUser appUser)
    {
        deliveryService.deleteFolder(request, appUser);
        return ResponseEntity.ok(new ResponseMessage("Success"));
    }

    @PostMapping("upload")
    public ResponseEntity<ResponseMessage> uploadFiles(@RequestParam("files") MultipartFile[] files, @RequestParam("deliveryId") Long deliveryId, @RequestParam("folder") String folder, @AuthenticationPrincipal AppUser appUser) {

        deliveryFileService.saveInFolder(files, deliveryId, folder, appUser);

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Files uploaded successfully"));
    }

    @PostMapping("uploadProfilePicture")
    public ResponseEntity<ResponseMessage> uploadProfilePicture(@RequestParam("file") MultipartFile file, @AuthenticationPrincipal AppUser appUser) {

        Path path = storageService.saveProfilePicture(appUser, file);

        appUser.setProfilePicturePath(path.toString());

        appUserRepository.save(appUser);

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("File uploaded successfully"));
    }

    @GetMapping("picture/{userId}")
    public ResponseEntity<Resource> getProfilePicture(@PathVariable("userId") Long userId) {

        AppUser user = appUserRepository.getOne(userId);

        if(user == null) {
            throw new DeliveryFileException("User not found", DeliveryFileExceptionType.FILE_NOT_FOUND);
        }

        String diskPath = user.getProfilePicturePath();

        Path filePath = Path.of(diskPath);

        if(filePath == null) {
            throw new DeliveryFileException("File not found", DeliveryFileExceptionType.FILE_NOT_FOUND);
        }

        Resource file = storageService.load(filePath);


        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }


}
