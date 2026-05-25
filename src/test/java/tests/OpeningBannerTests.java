package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import configs.TestConfig;
import helpers.Attachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import pages.FirstOpenPage;

import static io.qameta.allure.Allure.step;

public class OpeningBannerTests {
    FirstOpenPage firstOpenPage = new FirstOpenPage();
    @BeforeEach
    void setupAllure() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    void setUp() {
        TestConfig.applyConfiguration();
    }
    @Tag("Smoke")
    @Test
    @DisplayName("Видимость приветственного баннера")
    public void VisibleOpeningBannerTest(){
        step("Открываем главную страницу", () -> {
            firstOpenPage
                    .openPege();
        });
        step("Проверяем видимость элементов главной странницы", () -> {
            firstOpenPage
                    .typeOnboardingContainer()
                    .typeImageContainer()
                    .typeOnboardingTitle()
                    .typeUnderOnboardingTitle()
                    .typeMainOnboardingButton()
                    .typeMainOnboardingButtonTitle()
                    .typeCloseButtonVisible();
        });
    }
    @Test
    @DisplayName("Закрытие приветственного баннера")
    public void CloseOpeningBannerTest(){
        step("Открываем главную страницу", () -> {
            firstOpenPage
                    .openPege()
                    .typeOnboardingContainer();
        });
        step("Закрываем баннер", () -> {
            firstOpenPage
                    .typeCloseButtonVisible()
                    .typeCloseButtonClick();
        });
        step("Проверяем что баннер закрыт", () -> {
            firstOpenPage
                    .typeOnboardingContainerNotVisible();
        });
    }
    @Test
    @DisplayName("Видимость и подписи второго баннера")
    public void ClickNexOpeningBannerTest(){
        step("Открываем главную страницу", () -> {
            firstOpenPage
                    .openPege()
                    .typeOnboardingContainer();
        });
        step("Переходим на второй баннер", () -> {
            firstOpenPage
                    .typeMainOnboardingButtonClick();
        });
        step("Проверяем видимость и подписи второго баннера", () -> {
            firstOpenPage
                    .typeSecondSlideActive()
                    .typeSecondSlideTitle()
                    .typeSlideUnderTitle();
        });
    }
    @Tag("Smoke")
    @Test
    @DisplayName("Видимость элементов страницы \"Куда доставить\"")
    public void ClickSecondOpeningBannerTest(){
        step("Открываем главную страницу", () -> {
            firstOpenPage
                    .openPege()
                    .typeOnboardingContainer();
        });
        step("Переходим на страницу \"Куда доставить\"", () -> {
            firstOpenPage
                    .typeMainOnboardingButtonClick()
                    .typeActiveSlideButtonClick()
                    .typeSelectOnSearchButton();
        });
        step("Проверяем видимость элементов", () -> {
            firstOpenPage
                    .typeAssertPageOpened();
        });
    }
    @Test
    @DisplayName("Проверка input поиска")
    public void ClickAddressInputTest(){
        step("Открываем страницу ввода адреса", () -> {
            firstOpenPage
                    .openPege()
                    .typeMainOnboardingButtonClick()
                    .typeActiveSlideButtonClick()
                    .typeSelectOnSearchButton();
        });
        step("Вводим адрес", () -> {
            firstOpenPage
                    .typeEnterAddress("улица Новый Узбекистан 1");
        });
        step("Проверяем список выдачи", () -> {
            firstOpenPage
                    .typeSearchResultsDisplayed();
        });
    }
    @Test
    @DisplayName("Проверка появления модального окна геопозиции")
    public void clickSelectOnMapTest(){
        step("Открываем страницу ввода адреса", () -> {
            firstOpenPage
                    .openPege()
                    .typeMainOnboardingButtonClick()
                    .typeActiveSlideButtonClick()
                    .typeSelectOnSearchButton();

        });
        step("Выбираем \"Показать на карте\"", () -> {
            firstOpenPage
                    .typeClickSelectOnMap();
        });
        step("Проверяем модальное окно", () -> {
            firstOpenPage
                    .typeAssertGeoPermissionModal();
        });
    }
    @AfterEach
    void reportsFactureAndTearDown() {
        Attachments.screenshotAs("Скриншот");
        Attachments.addVideo();
        Attachments.browserConsoleLogs();
        Attachments.getVideoUrl();
        Attachments.pageSource();

        Selenide.closeWebDriver();
        SelenideLogger.removeListener("allure");
    }
}
