package configs;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestConfig {

    public static void applyConfiguration() {
        Configuration.browserSize = getResolution();
        Configuration.baseUrl = getBaseUrl();
        Configuration.browser = getBrowser();
        Configuration.browserVersion = getBrowserVersion();

        String remoteUrl = getRemoteUrl();
        if (remoteUrl != null && !remoteUrl.isEmpty()) {
            Configuration.remote = remoteUrl;
            setupRemoteCapabilities();
        }

        printConfiguration();
    }


    private static String getBaseUrl() {
        return System.getProperty("base.url", "https://www.uzumtezkor.uz");
    }

    private static String getRemoteUrl() {
        return System.getProperty("remote.url");
    }

    private static String getBrowser() {
        return System.getProperty("browser", "chrome");
    }

    private static String getBrowserVersion() {
        return System.getProperty("browser.version", "latest");
    }

    private static String getResolution() {
        return System.getProperty("resolution", "1920x1080");
    }

    private static void setupRemoteCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Подменяем IP на узбекский
        Map<String, Object> chromeOptions = new HashMap<>();
        chromeOptions.put("args", List.of(
                "--disable-dev-shm-usage",
                "--disable-blink-features=AutomationControlled"
        ));
        chromeOptions.put("prefs", Map.of(
                "profile.default_content_setting_values.geolocation", 1
        ));

        capabilities.setCapability("goog:chromeOptions", chromeOptions);

        // Selenoid options
        capabilities.setCapability("selenoid:options", Map.of(
                "enableVNC", true,
                "enableVideo", false,
                "env", List.of("TZ=Asia/Tashkent")  // ← часовой пояс Узбекистана
        ));

        Configuration.browserCapabilities = capabilities;
    }
    private static void printConfiguration() {
        System.out.println("=== Test Configuration ===");
        System.out.println("Base URL: " + Configuration.baseUrl);
        System.out.println("Browser: " + Configuration.browser);
        System.out.println("Browser Version: " + Configuration.browserVersion);
        System.out.println("Resolution: " + Configuration.browserSize);
        System.out.println("Remote: " + (Configuration.remote != null ? Configuration.remote : "local"));
        System.out.println("==========================");
    }
}
