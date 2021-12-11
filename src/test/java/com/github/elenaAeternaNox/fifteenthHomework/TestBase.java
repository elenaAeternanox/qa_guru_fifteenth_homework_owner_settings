package com.github.elenaAeternaNox.fifteenthHomework;

import com.github.elenaAeternaNox.fifteenthHomework.webConfig.WebDriverUtil;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void setUp() {
        WebDriverUtil.configure();
    }
}
