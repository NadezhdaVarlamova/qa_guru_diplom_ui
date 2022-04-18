package ru.vkusvill.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class SearchPage {
    SelenideElement h1SearchPage = $(".VV21_SearchPage__Title");

    @Step("Проверить отображение заголовка")
    public void checkHeadingSearch(String product)
    {
        h1SearchPage.shouldHave(Condition.text(product));
    }
}
