package varlamova.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SearchVVPage {
    SelenideElement
            h1SearchPage = $(".VV21_SearchPage__Title");

    @Step("Проверить отображение заголовка")
    public void checkH1(String product)
    {
        h1SearchPage.shouldHave(Condition.text(product));
    }
}
