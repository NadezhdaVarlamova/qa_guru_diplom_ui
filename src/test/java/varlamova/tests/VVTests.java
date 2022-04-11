package varlamova.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import varlamova.pages.DairyProductsVVPage;
import varlamova.pages.MainVVPage;
import varlamova.pages.SearchVVPage;

public class VVTests {
    @Test
    @Story("Главная страница ВкусВилл")
    @Feature("UI тесты vkusvill.ru")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Переход на страницу Акций")
    void goPromoPageTest() {
        MainVVPage mainVVPage = new MainVVPage();
        mainVVPage
                .openPage()
                .promoButtonClick();
        mainVVPage
                .pageUrl("https://vkusvill.ru/bonuses/");
    }

    @Test
    @Story("Главная страница ВкусВилл")
    @Feature("UI тесты vkusvill.ru")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Переход на страницу Магазины")
    void goShopPageTest() {
        MainVVPage mainVVPage = new MainVVPage();
        mainVVPage
                .openPage()
                .clickYes();
        mainVVPage
                .shopButtonClick();
        mainVVPage
                .pageUrl("https://vkusvill.ru/dostavka/");
    }

    @Test
    @Story("Главная страница ВкусВилл")
    @Feature("UI тесты vkusvill.ru")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Переход в каталог")
    void goCatalogPageTest() {
        MainVVPage mainVVPage = new MainVVPage();
        mainVVPage
                .openPage()
                .catalogButtonClick();
        mainVVPage
                .catalogButtonClick();
        mainVVPage
                .pageUrl("https://vkusvill.ru/goods/");
    }

    @Test
    @Story("Главная страница ВкусВилл")
    @Feature("UI тесты vkusvill.ru")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Поиск товара")
    void searchProductTest() {
        MainVVPage mainVVPage = new MainVVPage();
        SearchVVPage searchVVPage = new SearchVVPage();
        mainVVPage
                .openPage()
                .catalogButtonClick("Торт");
        searchVVPage
                .checkH1("Торт");


    }

    @Test
    @Story("Стрвница каталога Молочные продукты")
    @Feature("UI тесты vkusvill.ru")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка отображения попапа доставки при добавлении товара в корзину")
    void addProductToCartTest() {
        DairyProductsVVPage dairyProductsVVPage = new DairyProductsVVPage();
        dairyProductsVVPage
                .openPage()
                .addProductToCart();
        dairyProductsVVPage
                .checkPopup();
    }
}
