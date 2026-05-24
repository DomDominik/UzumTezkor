package pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;


public class FirstOpenPage {
    //Elements page 1.0
    private final SelenideElement onboardingContainer =
            $(".onboarding-off-canvas_onboardingSlide__qa2w_");
    private final SelenideElement imageContainer =
            $(".onboarding-off-canvas_imageContainer__MkQlk");
    private final SelenideElement onboardingTitle =
            $(".onboarding-off-canvas_onboardingSlideTitle__VJs6V");
    private final SelenideElement underOnboardingTitle =
            $(".onboarding-off-canvas_onboardingSlideDescription__KK4Vu");
    private final SelenideElement mainOnboardingButton =
            $("[data-test='location-onboarding-continue']");
    private final SelenideElement closeButton =
            $(".icon_icon__oYFlO.icon_black__NzANf.onboarding-off-canvas_closeIcon__NBu8X");
    // Elements page 1.1
    private final SelenideElement activeSlide =
            $(".carousel-item.active .onboarding-off-canvas_onboardingSlide__qa2w_");
    private final SelenideElement activeSlideTitle =
            $(".carousel-item.active .onboarding-off-canvas_onboardingSlideTitle__VJs6V");
    private final SelenideElement activeSlideUnderTitle =
            $(".carousel-item.active .onboarding-off-canvas_onboardingSlideDescription__KK4Vu");
    private final SelenideElement activeSlideButton =
            $(".carousel-item.active [data-test='location-onboarding-continue']");
    // Elements page 2.0  "Куда доставить"
    private final SelenideElement pageTitle =
            $(".carousel-item.active [data-test='navbar-title']");
    private final SelenideElement addressInput =
            $("[data-test='new-addres-search-input']");
    private final SelenideElement selectOnMapButton =
            $("[data-test='new-addres-search-select-on-map']");
    private final SelenideElement searchResultsContainer =
            $(".search-list_container__rmNFo");
    private final SelenideElement geoPermissionModal =
            $(".modal.show");
    private final SelenideElement geoModalTitle =
            $(".modal-title.h4");
    private final SelenideElement geoModalOkButton = $(".modal.show [data-test='primary-action']");
    //Actions
    public FirstOpenPage openPege() {
        open("/ru");
        return  this;
    }
    public FirstOpenPage typeOnboardingContainer(){
        onboardingContainer.shouldBe(visible);
        return this;
    }
    public FirstOpenPage typeOnboardingContainerNotVisible(){
        onboardingContainer.shouldNotBe(visible);
        return this;
    }
    public FirstOpenPage typeImageContainer() {
        imageContainer.$("img[alt='Бесплатная доставка']").shouldBe(visible);
        return this;
    }
    public FirstOpenPage typeOnboardingTitle() {
        onboardingTitle.shouldHave(text("Бесплатная доставка"));
        return this;
    }
    public FirstOpenPage typeUnderOnboardingTitle() {
        underOnboardingTitle.shouldHave(text("3 первых заказа доставим бесплатно"));
        return this;
    }
    public FirstOpenPage typeMainOnboardingButton(){
        mainOnboardingButton.shouldBe(visible);
        return this;
    }
    public FirstOpenPage typeMainOnboardingButtonTitle() {
        mainOnboardingButton.shouldHave(text("Далее"));
        return this;
    }
    public FirstOpenPage typeMainOnboardingButtonClick(){
        mainOnboardingButton.click();
        return this;
    }
    public FirstOpenPage typeCloseButtonVisible(){
        closeButton.shouldBe(visible);
        return this;
    }
    public FirstOpenPage typeCloseButtonClick(){
        closeButton.click();
        return this;
    }
    public FirstOpenPage typeSecondSlideActive() {
        activeSlide.shouldBe(visible);
        return this;
    }
    public FirstOpenPage typeSecondSlideTitle() {
        activeSlideTitle.shouldHave(text("Выбирайте любимое"));
        return this;
    }
    public FirstOpenPage typeSlideUnderTitle() {
        activeSlideUnderTitle.shouldHave(text("Доставляем из тысячи популярных ресторанов и магазинов"));
        return this;
    }
    public FirstOpenPage typeActiveSlideButtonClick(){
        activeSlideButton.click();
        return this;
    }
    public FirstOpenPage typeAssertPageOpened() {
        pageTitle.shouldHave(text("Куда доставить"));
        return this;
    }
    public FirstOpenPage typeEnterAddress(String address) {
        addressInput.shouldBe(visible);
        addressInput.setValue(address);
        return this;
    }
    public FirstOpenPage typeSearchResultsDisplayed() {
        searchResultsContainer.shouldBe(visible);
        searchResultsContainer.$$(".list_item__Lq2OI").shouldHave(sizeGreaterThan(0));
        return this;
    }
    public FirstOpenPage typeClickSelectOnMap() {
        selectOnMapButton.click();
        return this;
    }
    public FirstOpenPage typeAssertGeoPermissionModal() {
        geoPermissionModal.shouldBe(visible);
        geoModalTitle.shouldHave(text("Разрешите доступ к вашей геопозиции"));
        return this;
    }
    public FirstOpenPage closeGeoPermissionModalIfPresent() {
        if (geoPermissionModal.isDisplayed()) {
            geoModalOkButton.shouldBe(visible).click();
            geoPermissionModal.shouldNotBe(visible, Duration.ofSeconds(5));
        }
        return this;
    }
}
