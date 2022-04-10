package com.vaulin1506;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class simple_test {
    @BeforeEach
    void openPage() {
        Selenide.open("https://demoqa.com/automation-practice-form");
    }
    @AfterEach
    void close() {
        WebDriverRunner.closeWindow();
    }
    @Test
    void assertTest(){

    }

}
