package testBase;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import configs.TestConfig;
import helpers.Attachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
    @BeforeEach
    void setUp() {
        TestConfig.applyConfiguration();
    }
    @BeforeEach
    void setupAllure() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
    @AfterEach
    void reportsFactureAndTearDown() {
        Attachments.screenshotAs("Скриншот");
        Attachments.pageSource();
        Attachments.browserConsoleLogs();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Attachments.addVideo();
        Selenide.closeWebDriver();
        SelenideLogger.removeListener("allure");
    }
}
