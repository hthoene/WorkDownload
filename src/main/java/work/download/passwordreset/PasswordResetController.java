package work.download.passwordreset;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import work.download.responses.ResponseMessage;

@RestController
@RequestMapping("api/v1/reset")
@AllArgsConstructor
public class PasswordResetController {

    private final PasswordResetService passwordResetService;

    @PostMapping("requestEmail")
    public ResponseEntity<ResponseMessage> sendEmail(@RequestBody PasswordResetRequest request) {

        passwordResetService.sendEmail(request.getEmail());
        return ResponseEntity.ok(new ResponseMessage("Success"));

    }

    @PostMapping("confirm")
    public ResponseEntity<ResponseMessage> confirmToken(@RequestBody SetNewPasswordRequest request) {

        passwordResetService.changePassword(request);
        return ResponseEntity.ok(new ResponseMessage("Success"));

    }

}
