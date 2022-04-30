package com.vaulin1506.pages;

import com.codeborne.selenide.SelenideElement;
import com.vaulin1506.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PracticeFormPage {
    CalendarComponent calendar = new CalendarComponent();
    //locators
    SelenideElement subjectsInput = $("#subjectsInput");
    SelenideElement stateInput = $("#react-select-3-input");
    SelenideElement tableResponsive = $(".table-responsive");

    //actions
    public PracticeFormPage openPage() {
        open("/automation-practice-form");
        //Selenide.zoom(0.7);
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }
    public PracticeFormPage setFirstName(String value) {
        $("#firstName").setValue(value);
        return this;
    }
    public PracticeFormPage setLastName(String value) {
        $("#lastName").setValue(value);
        return this;
    }
    public PracticeFormPage setEmail(String value) {
        $("#userEmail").setValue(value);
        return this;
    }
    public PracticeFormPage setGenter(String value) {
        $("#genterWrapper").$(byText(value)).click();
        return this;
    }
    public PracticeFormPage setNumber(String value) {
        $("#userNumber").setValue(value);
        return this;
    }
    public PracticeFormPage setDateOfBierth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);
        return this;
    }
    public PracticeFormPage setSubjects(String value) {
        subjectsInput.setValue(value);
        subjectsInput.pressTab();
        return this;
    }
    public PracticeFormPage setHobbies(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();
        return this;
    }
    public PracticeFormPage uploadPicture(String value) {
        $("#uploadPicture").uploadFromClasspath(value);
        return this;
    }
    public PracticeFormPage setAddress(String value) {
        $("#currentAddress").setValue(value);
        return this;
    }
    public PracticeFormPage setStateCity(String state, String city) {
        stateInput.setValue(state);
        stateInput.pressTab();
        $("#city").click();
        $(byText(city)).click();
        $("#submit").pressEnter();
        return this;
    }
    public PracticeFormPage checkResult(String key, String value) {
        tableResponsive.shouldHave(text(key + " " + value));
        return this;
    }
    public PracticeFormPage checkResultText(String value) {
        tableResponsive.shouldHave(text(value));
        return this;
    }
    public PracticeFormPage checkResultStateCity(String key, String state, String city) {
        tableResponsive.shouldHave(text(key + " " + state + " " + city));
        return this;
    }
}
