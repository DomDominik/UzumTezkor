package configs;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
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

        // Настройки геолокации для Selenoid
        Map<String, Object> geolocation = new HashMap<>();
        geolocation.put("latitude", 41.311081);
        geolocation.put("longitude", 69.240562);
        geolocation.put("accuracy", 100);

        // Настройки Selenoid
        Map<String, Object> selenoidOptions = new HashMap<>();
        selenoidOptions.put("enableVNC", true);
        selenoidOptions.put("enableVideo", Boolean.parseBoolean(System.getProperty("video.enabled", "false")));
        selenoidOptions.put("geolocation", geolocation);  // ← геолокация внутрь selenoid:options

        capabilities.setCapability("selenoid:options", selenoidOptions);

        // Настройки браузера (разрешаем геолокацию)
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.geolocation", 1);
        capabilities.setCapability("prefs", prefs);

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
