package work.download.betacodes;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import work.download.appuser.AppUser;
import work.download.responses.ResponseMessage;

@RestController
@AllArgsConstructor
public class BetaCodeController {

    private final BetaCodeService codeService;

    @PostMapping("api/v1/betacode/new")
    public ResponseEntity<ResponseMessage> generateBetaCode(@AuthenticationPrincipal AppUser appUser) {

        if(!appUser.getAppUserRole().toString().equals("ADMIN")) {
            return new ResponseEntity<>(new ResponseMessage("Admin action not permitted"), HttpStatus.UNAUTHORIZED);
        }

        BetaCode betaCode = codeService.generateCode();
        return ResponseEntity.ok(new ResponseMessage(betaCode.getKey()));
    }

}
