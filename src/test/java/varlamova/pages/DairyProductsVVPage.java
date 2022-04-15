package varlamova.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class DairyProductsVVPage {
    SelenideElement
            addCartButton = $x("(//button[@class=\"CartButton__content CartButton__content--add js-delivery__basket--add\"])[1]"),
            cookieCloseButton = $x("//button[@class=\"Cookie__close js-cookie-warning-close\"]"),
            popapText = $x("(//div[contains(text(), 'Выберите способ получения')])[2]");

    @Step("Открыть страницу каталога Молочные продукты")
    public DairyProductsVVPage openPage(){
        open("https://vkusvill.ru/goods/molochnye-produkty-yaytso/");
        return this;
    }

    @Step("Добавить в корзину товар")
    public void addProductToCart ()
    {
        cookieCloseButton.click();
        addCartButton.click();
    }

    @Step("Проверить отображение поапа")
    public void checkPopup ()
    {
        popapText.shouldBe(Condition.visible);
    }
}
