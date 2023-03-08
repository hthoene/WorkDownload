package work.download.appuser;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import work.download.appuser.dto.UserStorageDto;
import work.download.appuser.requests.CompanyChangeRequest;
import work.download.storage.FilesStorageService;

@RestController
@RequestMapping("api/v1/user")
public class AppUserController {

    private final AppUserService appUserService;

    private final FilesStorageService storageService;

    public AppUserController(AppUserService appUserService, FilesStorageService storageService) {
        this.appUserService = appUserService;
        this.storageService = storageService;
    }

    @PostMapping("updateCompany")
    public ResponseEntity<AppUser> updateName(@RequestBody CompanyChangeRequest request, @AuthenticationPrincipal AppUser appuser) {
        AppUser appUser = appUserService.changeCompanyName(appuser, request.getCompanyName());
        return new ResponseEntity<>(appUser, HttpStatus.OK);
    }

    @PostMapping("storageInfo")
    public ResponseEntity<UserStorageDto> getUserStorage(@AuthenticationPrincipal AppUser appUser) {
        UserStorageDto userStorageDto = storageService.getUserStorageDto(appUser);
        return new ResponseEntity<>(userStorageDto, HttpStatus.OK);
    }

}
