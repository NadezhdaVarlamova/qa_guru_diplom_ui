package ru.vkusvill.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DairyProductsPageTests extends TestBase {
    @Test
    @Story("Страница каталога Молочные продукты")
    @Feature("UI тесты vkusvill.ru")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка отображения попапа авторизации при добавлении товара в корзину")
    void addProductToCartTest() {
        dairyProductsPage
                .openPage()
                .addProductToCart();
        dairyProductsPage
                .checkPopup();
    }

}
