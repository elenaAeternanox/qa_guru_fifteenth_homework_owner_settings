package com.github.elenaAeternaNox.fifteenthHomework.webConfig;

import com.github.elenaAeternaNox.fifteenthHomework.apiConfig.ApiConfig;
import org.aeonbits.owner.ConfigFactory;

import static com.codeborne.selenide.Selenide.open;

public class WebDriver {

    ApiConfig apiConfig = ConfigFactory.create(ApiConfig.class, System.getProperties());

    public void openMainPage() {
        open(apiConfig.getBaseUrl());
    }

}
