package work.download.utils;

import org.apache.commons.lang3.SystemUtils;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class GlobalConfig {

    private Environment environment;

    private static GlobalConfig Instance;

    public GlobalConfig(Environment environment) {
        Instance = this;
        this.environment = environment;

    }

    public static GlobalConfig getInstance() {
        return Instance;
    }

    public String getBackendUrl() {
        return environment.getProperty("work.backend-url");
    }

    public String getFrontendUrl() {
        return environment.getProperty("work.frontend-url");
    }

    public String getMode() {
        return environment.getProperty("work.mode");
    }

}
