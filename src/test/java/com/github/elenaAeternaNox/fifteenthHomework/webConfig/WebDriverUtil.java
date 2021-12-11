package com.github.elenaAeternaNox.fifteenthHomework.webConfig;

import com.codeborne.selenide.Configuration;
import com.github.elenaAeternaNox.fifteenthHomework.apiConfig.ApiConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.open;

public class WebDriverUtil {

    ApiConfig apiConfig = ConfigFactory.create(ApiConfig.class, System.getProperties());
    private static WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

    public void openMainPage() {
        open(apiConfig.getBaseUrl());
    }

    public static void configure() {
        Configuration.browser = config.browser();
        Configuration.browserVersion = config.browserVersion();
        Configuration.browserSize = config.browserSize();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--lang=en-en");

        if (System.getProperty("environmentBrowser").equals("selenoid")) {
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", false);
            Configuration.remote = config.remoteDriverUrl();
        }

        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        Configuration.browserCapabilities = capabilities;
        Configuration.timeout = 10000;
    }
}
