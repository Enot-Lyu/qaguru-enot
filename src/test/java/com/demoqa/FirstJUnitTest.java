package com.demoqa;

import org.junit.jupiter.api.*;

public class FirstJUnitTest {

    @BeforeAll
    static void beforeAll(){
        System.out.println("----------------#### Обертка один раз перед тестами @BeforeAll ####--------------------");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("----------------#### Обертка перед каждым тестом @BeforeEach ####--------------------");
    }

    @AfterEach
    void afterEach(){
        System.out.println("----------------#### Обертка после каждого теств  @AfterEach ####--------------------");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("----------------#### Обертка после всех тестов @AfterAll ####--------------------");
    }

    @Test          //это аннотация, можно поставить над классом, методом (функуии) чтобы JUnit знал что запускать
    void firstTest(){
        Assertions.assertTrue(3 > 2);
        System.out.println("----------------#### 1 Test####--------------------");
    }


    @Test          //это аннотация, можно поставить над классом, методом (функуии) чтобы JUnit знал что запускать
    void secondTest(){
        Assertions.assertTrue(3 > 2);
        System.out.println("----------------#### 2 Test####--------------------");
    }

}