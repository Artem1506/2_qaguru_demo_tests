package com.vaulin1506;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeForm_Tests {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
    }
    @Test
    void PracticeForm_Tests() {
        open("/automation-practice-form");
        $("[id=firstName]").setValue("Alex");
        $("[id=lastName]").setValue("Ivanov");
        $("[id=userEmail]").setValue("123@mail.com");
        $(".custom-radio:nth-child(1) > .custom-control-label").click();
        $("[id=userNumber]").setValue("0123456789");
        $("[id=userNumber]").setValue("0123456789");
        $("[id=dateOfBirthInput]").clear();
        $("[id=dateOfBirthInput]").setValue("15 Jun 1990");
        $("subjects-auto-complete__value-container").selectOption("Arts");

    }
}
