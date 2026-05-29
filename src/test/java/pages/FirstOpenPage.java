package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;


public class FirstOpenPage {
    //Elements page 1.0
    private final SelenideElement
            onboardingContainer =
            $(".onboarding-off-canvas_onboardingSlide__qa2w_"),
            imageContainer =
            $(".onboarding-off-canvas_imageContainer__MkQlk"),
            onboardingTitle =
            $(".onboarding-off-canvas_onboardingSlideTitle__VJs6V"),
            underOnboardingTitle =
            $(".onboarding-off-canvas_onboardingSlideDescription__KK4Vu"),
            mainOnboardingButton =
            $("[data-test='location-onboarding-continue']"),
            closeButton =
            $(".icon_icon__oYFlO.icon_black__NzANf.onboarding-off-canvas_closeIcon__NBu8X");

    // Elements page 1.1
    private final SelenideElement activeSlide =
            $(".carousel-item.active .onboarding-off-canvas_onboardingSlide__qa2w_"),
            activeSlideTitle =
            $(".carousel-item.active .onboarding-off-canvas_onboardingSlideTitle__VJs6V"),
            activeSlideUnderTitle =
            $(".carousel-item.active .onboarding-off-canvas_onboardingSlideDescription__KK4Vu"),
            activeSlideButton =
            $(".carousel-item.active [data-test='location-onboarding-continue']");

    // Elements page 1.4  "Куда доставить"
    private final SelenideElement pageTitle =
            $(".carousel-item.active [data-test='navbar-title']"),
            addressInput =
            $("[data-test='new-addres-search-input']"),
            selectOnSearchButton =
            $("[data-test='new-addres-map-search']"),
            searchResultsContainer =
            $(".search-list_container__rmNFo");

    // Elements page 1.3  "Вне зоны доставки"
    private final SelenideElement addressInputBlock =
            $("[data-test='new-address-map-text']"),
            confirmAddressButton =
            $("[data-test='new-addres-map-button']"),
            objectTitle =
            $(".address-map_title__usr4K");

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
    public FirstOpenPage typeSelectOnSearchButton() {
        selectOnSearchButton.shouldBe(Condition.enabled, Duration.ofSeconds(10));
        selectOnSearchButton.shouldBe(Condition.visible);
        selectOnSearchButton.click();
        return this;
    }
    public FirstOpenPage typeAddressInputBlockVisible() {
        addressInputBlock.shouldBe(Condition.visible);
        addressInputBlock.shouldHave(text("Вне зоны доставки?"));
        return this;
    }
    public FirstOpenPage typeConfirmButtonVisible() {
        confirmAddressButton.shouldBe(Condition.visible);
        return this;
    }
    public FirstOpenPage typePageTitleVisible() {
        objectTitle.shouldBe(Condition.visible);
        return this;
    }
    public FirstOpenPage typeConfirmButtonDisabled() {
        confirmAddressButton.shouldHave(Condition.attribute("disabled"));
        return this;
    }
    public FirstOpenPage typePageTitleText() {
        objectTitle.shouldHave(Condition.text("Куда доставить?"));
        return this;
    }
}
