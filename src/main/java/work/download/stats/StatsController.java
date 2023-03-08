package work.download.stats;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import work.download.appuser.AppUser;
import work.download.responses.ResponseMessage;

@RequestMapping("api/v1/stats")
@RestController
@AllArgsConstructor
public class StatsController {

    private final StatsService statsService;

    @PostMapping("userAmount")
    public ResponseEntity<ResponseMessage> getEnabledUserAmount(@AuthenticationPrincipal AppUser appUser) {

        if(!appUser.getAppUserRole().toString().equals("ADMIN")) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        int registeredUsersAmount = statsService.getRegisteredUsersAmount();
        return new ResponseEntity<>(new ResponseMessage(String.valueOf(registeredUsersAmount)), HttpStatus.OK);
    }

    @PostMapping("storageStats")
    public ResponseEntity<StorageDto> getStorageStats(@AuthenticationPrincipal AppUser appUser) {
        if(!appUser.getAppUserRole().toString().equals("ADMIN")) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return ResponseEntity.ok(statsService.getStorageStats());

    }

    @PostMapping("storageUsed")
    public ResponseEntity<ResponseMessage> getStorageUsed(@AuthenticationPrincipal AppUser appUser) {
        if(!appUser.getAppUserRole().toString().equals("ADMIN")) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return ResponseEntity.ok(new ResponseMessage(statsService.getTotalUsedSpace()));

    }

    @PostMapping("storageFree")
    public ResponseEntity<ResponseMessage> getStorageFree(@AuthenticationPrincipal AppUser appUser) {
        if(!appUser.getAppUserRole().toString().equals("ADMIN")) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return ResponseEntity.ok(new ResponseMessage(statsService.getFreeSpaceLeft()));

    }


}
