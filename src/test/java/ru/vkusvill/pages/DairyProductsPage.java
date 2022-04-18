package ru.vkusvill.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class DairyProductsPage {
    SelenideElement
            addCartButton = $("button.CartButton__content.CartButton__content--add.js-delivery__basket--add", 1),
            cookieCloseButton = $("button.Cookie__close.js-cookie-warning-close"),
            popupText = $(byText("Выберите способ получения"));

    @Step("Открыть страницу каталога Молочные продукты")
    public DairyProductsPage openPage() {
        open("/goods/molochnye-produkty-yaytso/");
        return this;
    }

    @Step("Добавить в корзину товар")
    public void addProductToCart() {
        cookieCloseButton.click();
        addCartButton.click();
    }

    @Step("Проверить отображение попапа")
    public void checkPopup() {
        popupText.shouldBe(visible);
    }
}
