package work.download.registration.service;

import work.download.appuser.AppUser;
import work.download.appuser.AppUserRole;
import work.download.appuser.AppUserService;
import work.download.betacodes.BetaCodeRepository;
import work.download.betacodes.BetaCodeService;
import work.download.email.EmailSender;
import work.download.email.EmailTemplateGenerator;
import work.download.registration.request.BetaRegistrationRequest;
import work.download.registration.validator.EmailValidator;
import work.download.registration.request.RegistrationRequest;
import work.download.registration.token.ConfirmationToken;
import work.download.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import work.download.utils.GlobalConfig;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final GlobalConfig globalConfig;
    private final AppUserService appUserService;
    private final EmailValidator emailValidator;
    private final ConfirmationTokenService confirmationTokenService;
    private final EmailSender emailSender;

    private final BetaCodeService betaCodeService;

    private final EmailTemplateGenerator emailTemplateGenerator;

    public String register(BetaRegistrationRequest request) {
        boolean isValidEmail = emailValidator.
                test(request.getEmail());

        if (!isValidEmail) {
            throw new IllegalStateException("email not valid");
        }

        String betaCode = request.getBetaCode();

        boolean isValid = betaCodeService.checkBetaCode(betaCode);

        if(!isValid) {
            throw new RuntimeException("Beta code invalid");
        }



        String token = appUserService.signUpUser(
                new AppUser(
                        request.getEmail(),
                        request.getPassword(),
                        AppUserRole.FREELANCER,
                        request.getCompanyName()

                )
        );

        String link = globalConfig.getBackendUrl() + "api/v1/registration/confirm?token=" + token;
        emailSender.sendConfirmation(
                request.getEmail(),
                "Confirm your account",
                emailTemplateGenerator.createConfirmEmail(request.getCompanyName(), link, "https://work.download/"));

        betaCodeService.deleteCode(betaCode);

        return "Success";
    }

    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("token not found"));

        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("email already confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            System.out.println("token expired");
        }

        confirmationTokenService.setConfirmedAt(token);
        appUserService.enableAppUser(
                confirmationToken.getAppUser().getEmail());
        return "confirmed";
    }

}
