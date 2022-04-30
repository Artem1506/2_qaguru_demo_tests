package com.vaulin1506;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import com.vaulin1506.pages.PracticeFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.Locale;
import static java.lang.String.format;

public class PracticeFormTests {

    Faker faker = new Faker(new Locale("en-GB"));

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            subjectsInput = "Arts",
            currentAddress = faker.address().fullAddress(),
            state = "NCR",
            city = "Delhi";

    String expectedFullName = format("%s %s", firstName, lastName);
    PracticeFormPage formPage = new PracticeFormPage();

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void formTests() {

        formPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGenter("Male")
                .setNumber(userNumber)
                .setDateOfBierth("27", "June", "1990")
                .setSubjects(subjectsInput)
                .setHobbies("Sports")
                .uploadPicture("123.png")
                .setAddress(currentAddress)
                .setStateCity(state, city);

        formPage.checkResult("Student Name", expectedFullName)
                .checkResult("Mobile", userNumber)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", "Male")
                .checkResultText("Date of Birth 27 June,1990")
                .checkResult("Subjects", subjectsInput)
                .checkResultText("Hobbies Sports")
                .checkResultText("Picture 123.png")
                .checkResult("Address", currentAddress)
                .checkResultStateCity("State and City", state, city);
           }
}
