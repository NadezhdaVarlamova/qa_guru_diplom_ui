package ru.vkusvill.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPage {
    SelenideElement
            promoButton = $x("//a[@href=\"/bonuses/\"]"),
            shopButton = $x("//a[@href=\"/dostavka/\"]"),
            yesButton = $x("//span[text()=\"Да\"]"),
            catalogButton = $("#js-header-catalog-shower"),
            search = $(".js-vv21-search__search-input");


    @Step("Открыть главную страницу.")
    public MainPage openPage() {
        open("/");
        return this;
    }

    @Step("Кликнуть на вкладку 'Акции'")
    public void promoButtonClick() {
        promoButton.click();
    }

    @Step("Кликнуть на вкладку 'Магазины'")
    public void shopButtonClick() {
        shopButton.click();
    }

    @Step("Нажать Да в попапе города")
    public void clickYes() {
        if (yesButton.isDisplayed()) {
            yesButton.click();
        }
    }

    @Step("Кликнуть на 'Каталог'")
    public void catalogButtonClick() {
        catalogButton.click();
    }

    @Step("Проверить редирект на страницу {url}")
    public void checkPageUrl(String url) {
        String urlPage = WebDriverRunner.url();
        assertEquals(urlPage, url);
    }

    @Step("Ввести в поиск запрос {}")
    public void catalogButtonClick(String product) {
        search.setValue(product);
        search.pressEnter();
    }
}
