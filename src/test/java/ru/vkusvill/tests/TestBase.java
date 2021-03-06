package ru.vkusvill.tests;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;


import ru.vkusvill.config.TestsConfig;
import ru.vkusvill.helpers.Attach;
import ru.vkusvill.pages.DairyProductsPage;
import ru.vkusvill.pages.MainPage;
import ru.vkusvill.pages.SearchPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    MainPage mainPage = new MainPage();
    DairyProductsPage dairyProductsPage = new DairyProductsPage();
    SearchPage searchPage = new SearchPage();

    @BeforeAll
    static void setUp() {
        TestsConfig config = ConfigFactory.create(TestsConfig.class, System.getProperties());

        String browserName = String.valueOf(config.browser());
        String browserVersion = config.version();
        String browserResolution = config.resolution();

        Configuration.browser = browserName;
        Configuration.browserVersion = browserVersion;
        Configuration.baseUrl = config.baseUrl();
        Configuration.browserSize = browserResolution;

        if (config.remote()) {
            String selenoidLogin = config.selenoidLogin(),
                    selenoidPassword = config.selenoidPassword();

            Configuration.remote = String.format("https://%s:%s@selenoid.autotests.cloud/wd/hub",
                    selenoidLogin, selenoidPassword);

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        }

        Attach.attachAsText("Browser: ", browserName);
        Attach.attachAsText("Version: ", browserVersion);
        Attach.attachAsText("Remote: ", String.valueOf(config.remote()));
        Attach.attachAsText("Login: ", config.selenoidLogin());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}
