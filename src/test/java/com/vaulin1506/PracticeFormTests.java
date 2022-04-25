package com.vaulin1506;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void formTests() {

        open("/automation-practice-form");
        //Selenide.zoom(0.6);

        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("123@mail.com");
        $("#genterWrapper").$(byText("Male")).click();
        //$(".custom-radio:nth-child(1) > .custom-control-label").click(); исправил
        $("#userNumber").setValue("0123456789");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("1990");
        $("[aria-label$='June 27th, 1990']").click();
        $("#subjectsInput").setValue("Arts");
        $("#subjectsInput").pressTab();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        //$(".custom-checkbox:nth-child(1) > .custom-control-label").click(); исправил
        $("#uploadPicture").uploadFromClasspath("123.png");
        $("#currentAddress").val("Volgograd");
        $("#react-select-3-input").setValue("NCR");
        $("#react-select-3-input").pressTab();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").pressEnter();

        $(".table-responsive").shouldHave(text("Student Name " + "Alex " + "Ivanov"),
                text("Mobile 0123456789"),
                text("Student Email 123@mail.com"),
                text("Gender Male"),
                text("Date of Birth 27 June,1990"),
                text("Subjects Arts"),
                text("Hobbies Sports"),
                text("Picture 123.png"),
                text("Address Volgograd"),
                text("State and City NCR Delhi"));
        //sleep(5000);

    }
}
