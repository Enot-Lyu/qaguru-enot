package com.demoqa;

import org.junit.jupiter.api.Test;
import java.io.File;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormTestsOld extends TestBase {    //extends TestBase прописаны конфигурации

    @Test        //это аннотация, можно поставить над классом, методом (функуии) чтобы JUnit знал что запускать
    void mySuccessFullFillFormTest(){

        open("/automation-practice-form");

        $("#firstName").setValue("Enot");           //TODO Вод имени
        $("#lastName").setValue("Lyu");             //TODO Вод фамилии
        $("#userEmail").setValue("ly@ya.ru");       //TODO Вод емайл
        //Замечание: Только гендер и хобби лучше выбирать по тексту, т.к. последовательность и количество кнопок может измениться и тест упадет
        //было  $("[for=gender-radio-2]").click();
        $("#genterWrapper").$(byText("Female")).click(); //TODO Выбор гендера (женский)
        $("#userNumber").setValue("1234567890");    //TODO Вод номера телефона
        $("#dateOfBirthInput").click();             //TODO выбор даты рождения

        //Выбрать дату рождения (как сделать правильно по селекторам)
        $(".react-datepicker__month-container").$(byText("February")).click();
        $(".react-datepicker__month-container").$(byText("1996")).click();
        $(".react-datepicker__month-container").$(byText("10")).click();

        //Заполнение субъекта (вторая строка блока не симпатичная)
        $("#subjectsContainer").click();
        $(".subjects-auto-complete__input").$("#subjectsInput").setValue("m");
        $("[id=subjectsContainer]").$(byText("Computer Science")).click();

        //Замечание: Только гендер и хобби лучше выбирать по тексту, т.к. последовательность и количество кнопок может измениться и тест упадет
        $("#hobbiesWrapper").$(byText("Sports")).click();//TODO Клик на чек-бокс выбор хобби
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        //$("[for=hobbies-checkbox-1]").click();               //TODO Клик на чек-бокс выбор хобби


        //Загрузка изображения (пришлось подсмотреть)
        //$("#uploadPicture").uploadFile(new File("C:/test/t.txt"));//TODO Клик на кнопку "Выберте файл"
        //$("#uploadPicture").uploadFile(new File("src/test/resources/t.txt"));//TODO Клик на кнопку "Выберте файл"
        $("#uploadPicture").uploadFile(new File("C:/Users/Пользователь/Documents/GitHub/qaguru-enot/src/test/resources/file/ава.jpg"));//TODO Клик на кнопку "Выберте файл"
        //$("#uploadPicture").uploadFromClasspath("C:/test/t.txt");

        //Адрес проживания
        $("#currentAddress").setValue("Ihzevsk");

        //
        $(".css-1wa3eu0-placeholder").click();
        $(byText("Haryana")).click();

        $(".css-1wa3eu0-placeholder").click();
        $(byText("Panipat")).click();

        //Клик на кнопку summit
        $("#submit").click();//TODO Клик на кнопку после заполнения формы

        //Проверка появления модального окна
        $(".modal-content").should(appear); //TODO Проверка появления модального окна
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form")); //TODO Проверка появления модального окна
          //$(".modal-content").should(appear);

        //Сравнение данных таблицы (после неудачного теста, значения отображались в консоли)
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
        //Assertions.assertEquals("Student Name", "Enot Lyu");
    }

}
