package com.vaulin1506;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class PracticeForm_Tests {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void Practice_Form_Tests() {
        //String firstName = "Alex";
        //String lastName = "Ivanov";
        //String email = "qwe@mail.com";
        //String gender = "Male";
        //String userNumber = "0123456789";
        //LocalDate date = LocalDate.of(1901, 5, 5);
        //String month = Month.of(date.getMonthValue()).getDisplayName(TextStyle.FULL_STANDALONE, Locale.forLanguageTag("en"));

        //String subjectsInput = "Computer Science";
        //String hobby = "Sports";
        //String imgPath = "img/Pushkin.jpg";
        //String currentAddress = "A N L Colony, Lucknow, Lucknow, UTTAR PRADESH, 226004";
        //SelenideElement stateCityWrapper = $("#stateCity-wrapper");
        //String state = "Uttar Pradesh";
        //String city = "Lucknow";

        open("/automation-practice-form");
        Selenide.zoom(0.7);

        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("123@mail.com");
        $(".custom-radio:nth-child(1) > .custom-control-label").click();
        $("#userNumber").setValue("0123456789");
        $(".react-datepicker__month-select").selectOption("June"); //Выбор месяца
        $(".react-datepicker__year-select").selectOption("1990"); //Выбор года
        $("[aria-label$='June 15th, 1990']").click();
        //$("#dateOfBirthInput").click();
        // $("#dateOfBirthInput").setValue(birthday).pressEnter();

        //$(".react-datepicker__month-select").selectOption("5");
        //$(".react-datepicker__year-select").selectOption(String.valueOf(birth.getYear()));
        // $("[aria-label$='" + month + " " + birth.getDayOfMonth() + "th, " + birth.getYear() + "']").click();
        $$("[id^='react-select-2-option']");


    }
}
