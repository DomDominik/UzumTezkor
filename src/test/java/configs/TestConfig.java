package configs;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestConfig {

    public static void applyConfiguration() {
        Configuration.browserSize = System.getProperty("resolution", "1920x1080");
        Configuration.baseUrl = System.getProperty("base.url", "https://www.uzumtezkor.uz");
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browser.version", "128");

        String remoteUrl = System.getProperty("remote.url");
        if (remoteUrl != null && !remoteUrl.isEmpty()) {
            Configuration.remote = remoteUrl;
            setupRemoteCapabilities();
        }
    }

    private static void setupRemoteCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }
}
