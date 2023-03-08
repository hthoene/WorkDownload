package work.download.stats;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import work.download.appuser.AppUserRepository;
import work.download.storage.FilesStorageService;

@Service
@AllArgsConstructor
public class StatsService {

    private final AppUserRepository appUserRepository;
    private final FilesStorageService storageService;


    public int getRegisteredUsersAmount() {
        return appUserRepository.countActiveAppUsers();
    }

    public String getTotalUsedSpace() {
        return storageService.getReadableFileSize(storageService.getTotalStorageUsed());
    }

    public String getFreeSpaceLeft() {
        return storageService.getReadableFileSize(storageService.getFreeStorageLeft());
    }

    public StorageDto getStorageStats() {
        StorageDto storageDto = new StorageDto();

        long storageUsed = storageService.getTotalStorageUsed();
        long storageFree = storageService.getFreeStorageLeft();
        long storageTotal = storageService.getTotalStorage();
        long diskStorageUsed = storageService.getDiskSpaceUsed();


        storageDto.setStorageUsed(storageUsed);
        storageDto.setStorageFree(storageFree);
        storageDto.setStorageTotal(storageTotal);
        storageDto.setTotalDiskStorageUsed(diskStorageUsed);

        storageDto.setStorageUsedText(storageService.getReadableFileSize(storageUsed));
        storageDto.setStorageFreeText(storageService.getReadableFileSize(storageFree));
        storageDto.setStorageTotalText(storageService.getReadableFileSize(storageTotal));
        storageDto.setTotalDiskStorageUsedText(storageService.getReadableFileSize(diskStorageUsed));

        return storageDto;

    }
}
