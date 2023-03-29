package com.demoqa;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormTests extends TestBase {    //extends TestBase прописаны конфигурации

    @Test
        //это аннотация, можно поставить над классом, методом (функуии) чтобы JUnit знал что запускать
    void mySuccessFullFillFormTest(){

        open("/automation-practice-form");

        $("#firstName").setValue("Enot");           //TODO Вод имени
        $("#lastName").setValue("Lyu");             //TODO Вод фамилии
        $("#userEmail").setValue("ly@ya.ru");       //TODO Вод емайл
        $("[for=gender-radio-2]").click();          //TODO Выбор гендера (женский)
        $("#userNumber").setValue("1234567890");    //TODO Вод номера телефона

        $("#dateOfBirthInput").click();             //TODO выбор даты рождения



        //Выбрать дату рождения (как сделать правильно по селекторам)
        $(".react-datepicker__month-container").$(byText("February")).click();
        $(".react-datepicker__month-container").$(byText("1996")).click();
        $(".react-datepicker__month-container").$(byText("10")).click();

        //Заполнение субъекта
        //$(byText("subjectsContainer")).setValue("subjectsContainer");
       // $(".col-md-9 col-sm-12")
        //$(".col-md-9 col-sm-12").setValue("subjectsContainer");

        $("[for=hobbies-checkbox-1]").click();               //TODO Клик на чек-бокс выбор хобби
        $("[for=hobbies-checkbox-2]").click();               //TODO Клик на чек-бокс выбор хобби
        $("[for=hobbies-checkbox-3]").click();               //TODO Клик на чек-бокс выбор хобби

        //Загрузка изображения
        $("#uploadPicture").click();                         //TODO Клик на кнопку "Выберте файл"

        $("#submit").click();


        $("").shouldHave(text(""));


    }

}
