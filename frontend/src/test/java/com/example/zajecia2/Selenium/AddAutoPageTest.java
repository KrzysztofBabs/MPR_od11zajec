package com.example.zajecia2.Selenium;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddAutoPageTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp(){
        this.driver = new ChromeDriver();
    }

    @Test
    public void testAddAutoForm(){
        AddAutoPage page = new AddAutoPage(driver)
                .open()
                .fillInModelInput("Porsche")
                .fillInRokProdukcjiInput(2022)
                .clickSubmitButton();
    }


}
