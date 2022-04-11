package varlamova.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;


import varlamova.config.TestsConfig;
import varlamova.helpers.Attach;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    @BeforeAll
    static void setUp(){
        TestsConfig config = ConfigFactory.create(TestsConfig.class, System.getProperties());

        String browserName = String.valueOf(config.getBrowser());
        String browserVersion = config.getBrowserVersion();
        String browserResolution = config.getResolution();

        Configuration.browser = browserName;
        Configuration.browserVersion = browserVersion;
        Configuration.baseUrl = config.getBaseUrl();
        Configuration.browserSize = browserResolution;
        String url = System.getProperty("url");

        if (config.getRemote()){
            String selenoidLogin = config.selenoidLogin(),
                    selenoidPassword = config.selenoidPassword();

//            Configuration.remote = String.format("https://%s:%s@selenoid.autotests.cloud/wd/hub",
//                    selenoidLogin, selenoidPassword);
            String remote = "https://" + selenoidLogin + ":" + selenoidPassword + "@" + url;
            Configuration.remote = remote;

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        }

        Attach.attachAsText("Browser: ", browserName);
        Attach.attachAsText("Version: ", browserVersion);
        Attach.attachAsText("Remote: ", String.valueOf(config.getRemote()));
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
