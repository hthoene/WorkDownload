package work.download.ping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/test")
public class PingController {

    @GetMapping("ping")
    public String ping() {
        return "pong";
    }

}
