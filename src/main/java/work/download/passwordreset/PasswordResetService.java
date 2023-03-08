package work.download.passwordreset;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import work.download.appuser.AppUser;
import work.download.appuser.AppUserRepository;
import work.download.email.EmailSendService;
import work.download.security.PasswordEncoder;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PasswordResetService {

    private final AppUserRepository appUserRepository;
    private final PasswordResetTokenRepository tokenRepository;

    private final EmailSendService emailSendService;

    private final PasswordEncoder passwordEncoder;

    public boolean sendEmail(String email) {

        Optional<AppUser> byEmail = appUserRepository.findByEmail(email);
        if(byEmail.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        AppUser appUser = byEmail.get();

        PasswordResetToken currentToken = appUser.getPasswordResetToken();

        if(currentToken != null) {
            if(currentToken.getExpiryDate().isBefore(LocalDateTime.now())) {

                currentToken.setAppUser(null);
                tokenRepository.delete(currentToken);

            } else {
                throw new RuntimeException("Token already exists. Please wait.");
            }
        }

        PasswordResetToken passwordResetToken = new PasswordResetToken();

        passwordResetToken.setAppUser(appUser);

        PasswordResetToken save = tokenRepository.save(passwordResetToken);

        emailSendService.sendPasswordReset(appUser.getEmail(), save.getToken());

        return true;


    }


    public void changePassword(SetNewPasswordRequest request) {

        PasswordResetToken token = tokenRepository.findByToken(request.getToken());

        if(token == null) throw new RuntimeException("Token not found");

        if(token.getExpiryDate().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Token expired");
        }

        AppUser appUser = token.getAppUser();

        appUser.setPassword(passwordEncoder.bCryptPasswordEncoder().encode(request.getPassword()));

        appUserRepository.save(appUser);

        tokenRepository.delete(token);


    }
}
