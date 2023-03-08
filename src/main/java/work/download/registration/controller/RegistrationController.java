package work.download.registration.controller;

import work.download.registration.request.BetaRegistrationRequest;
import work.download.registration.request.RegistrationRequest;
import work.download.registration.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import work.download.utils.GlobalConfig;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;
    private final GlobalConfig globalConfig;

    @PostMapping
    public String register(@RequestBody BetaRegistrationRequest request) {
        return registrationService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token, HttpServletResponse httpResponse) {
        try {
            registrationService.confirmToken(token);
        } catch(Exception ex) {
            return "<h1>Already confirmed</h1><p>Error: " + ex.getMessage() + "</p>";
        }
        try {
            httpResponse.sendRedirect(globalConfig.getFrontendUrl() + "login");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Confirmed";
    }

}
