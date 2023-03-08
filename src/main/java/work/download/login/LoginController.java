package work.download.login;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import work.download.appuser.AppUser;
import work.download.appuser.PrivateAppUserDto;

@RestController
@RequestMapping("api/v1/login")
public class LoginController {

    private final ModelMapper modelMapper;

    public LoginController(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @PostMapping()
    public ResponseEntity<PrivateAppUserDto> login(@AuthenticationPrincipal AppUser appUser) {
        if(appUser == null) return ResponseEntity.badRequest().body(null);
        PrivateAppUserDto privateAppUserDto = modelMapper.map(appUser, PrivateAppUserDto.class);
        return ResponseEntity.ok(privateAppUserDto);

    }

}
