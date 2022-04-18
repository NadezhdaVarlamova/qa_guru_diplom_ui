package ru.vkusvill.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MainPageTests extends TestBase {
    @Test
    @Story("Главная страница ВкусВилл")
    @Feature("UI тесты vkusvill.ru")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Переход на страницу Акций")
    void goPromoPageTest() {
        mainPage
                .openPage()
                .promoButtonClick();
        mainPage
                .checkPageUrl("https://vkusvill.ru/bonuses/");
    }

    @Test
    @Story("Главная страница ВкусВилл")
    @Feature("UI тесты vkusvill.ru")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Переход на страницу Магазины")
    void goShopPageTest() {
        mainPage
                .openPage()
                .clickYes();
        mainPage
                .shopButtonClick();
        mainPage
                .checkPageUrl("https://vkusvill.ru/dostavka/");
    }

    @Test
    @Story("Главная страница ВкусВилл")
    @Feature("UI тесты vkusvill.ru")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Переход в каталог")
    void goCatalogPageTest() {
        mainPage
                .openPage()
                .catalogButtonClick();
        mainPage
                .catalogButtonClick();
        mainPage
                .checkPageUrl("https://vkusvill.ru/goods/");
    }

    @Test
    @Story("Главная страница ВкусВилл")
    @Feature("UI тесты vkusvill.ru")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Поиск товара")
    void searchProductTest() {
        mainPage
                .openPage()
                .catalogButtonClick("Торт");
        searchPage
                .checkHeadingSearch("Торт");
    }
}
