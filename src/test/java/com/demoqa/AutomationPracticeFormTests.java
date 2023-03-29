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



        //Выбрать дату рождения
        $(".react-datepicker__header__dropdown react-datepicker__header__dropdown--select").click();
       // <div class="react-datepicker__month-dropdown-container react-datepicker__month-dropdown-container--select"><select class="react-datepicker__month-select"><option value="0">January</option><option value="1">February</option><option value="2">March</option><option value="3">April</option><option value="4">May</option><option value="5">June</option><option value="6">July</option><option value="7">August</option><option value="8">September</option><option value="9">October</option><option value="10">November</option><option value="11">December</option></select></div>
        $("div .react-datepicker__header__dropdown react-datepicker__header__dropdown--select").$(".react-datepicker__month-select").$("[value=1]").click();
        $(byText("February")).click();             //TODO выбор даты рождения
        //$(".react-datepicker__month-dropdown-container react-datepicker__month-dropdown-container--select").$("[value=1]").click();
        //$("[value=1]").getSelectedOptionValue();




        $("[for=hobbies-checkbox-1]").click();               //TODO Клик на чек-бокс выбор хобби
        $("[for=hobbies-checkbox-2]").click();               //TODO Клик на чек-бокс выбор хобби
        $("[for=hobbies-checkbox-3]").click();               //TODO Клик на чек-бокс выбор хобби
        $("#uploadPicture").click();                //TODO Клик на кнопку "Выберте файл"

        $("#submit").click();


        $("").shouldHave(text(""));


    }

}
