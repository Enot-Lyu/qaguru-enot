package com.demoqa;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AutomationPracticeFormTests extends TestBase {

    @Test
    void mySuccessFullFillFormTest(){

        open("/automation-practice-form");

        $("#firstName").setValue("Enot");
        $("#lastName").setValue("Lyu");
        $("#userEmail").setValue("ly@ya.ru");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-container").$(byText("February")).click();
        $(".react-datepicker__month-container").$(byText("1996")).click();
        $(".react-datepicker__month-container").$(byText("10")).click();
        $("#subjectsContainer").click();
        $(".subjects-auto-complete__input").$("#subjectsInput").setValue("m");
        $("[id=subjectsContainer]").$(byText("Computer Science")).click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFile(new File("C:/Users/Пользователь/Documents/GitHub/qaguru-enot/src/test/resources/file/ава.jpg"));
        $("#currentAddress").setValue("Ihzevsk");
        $(".css-1wa3eu0-placeholder").click();
        $(byText("Haryana")).click();
        $(".css-1wa3eu0-placeholder").click();
        $(byText("Panipat")).click();
        $("#submit").click();
        $(".modal-content").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Enot Lyu"),
                text("ly@ya.ru"),
                text("Female"),
                text("1234567890"),
                text("10 February,1996"),
                text("Computer Science"),
                text("Sports, Reading, Music"),
                text("ава.jpg"),
                text("Ihzevsk"),
                text("Haryana Panipat")
        );
        $("#closeLargeModal").click();
    }
}
