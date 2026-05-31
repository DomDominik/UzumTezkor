package tests;

import org.junit.jupiter.api.*;
import pages.FirstOpenPage;
import testBase.TestBase;

import static io.qameta.allure.Allure.step;

public class OpeningBannerTests extends TestBase {
    FirstOpenPage firstOpenPage = new FirstOpenPage();
    @Test
    @DisplayName("Видимость приветственного баннера")
    public void visibleOpeningBannerTest(){
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
    public void closeOpeningBannerTest(){
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
    @DisplayName("Видимость и подписи второго приветственного баннера")
    public void clickNexOpeningBannerTest(){
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
    @Test
    @DisplayName("Видимость элементов страницы \"Куда доставить\"")
    public void clickSecondOpeningBannerTest(){
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
    @DisplayName("Проверка поиска")
    public void clickAddressInputTest(){
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
    @DisplayName("Проверка видимости элементов контейнера \"Куда доставить?\"")
    public void clickSelectOnMapTest(){
        step("Открываем страницу подтверждения адреса", () -> {
            firstOpenPage
                    .openPege()
                    .typeMainOnboardingButtonClick()
                    .typeActiveSlideButtonClick();
        });
        step("Проверяем подписи контейнера", () -> {
            firstOpenPage
                    .typeAddressInputBlockVisible()
                    .typePageTitleVisible()
                    .typeConfirmButtonVisible()
                    .typePageTitleText();
        });
        step("Проверяем состояние кнопки \"Подтвердить адрес\"", () -> {
            firstOpenPage
                    .typeConfirmButtonDisabled();
        });
    }
}
