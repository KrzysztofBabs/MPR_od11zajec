package com.example.zajecia2.Selenium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteAutoPageTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp(){
        this.driver = new ChromeDriver();
    }

    @Test
    public void testDeleteAutoForm(){
        DeleteAutoPage page = new DeleteAutoPage(driver)
                .open().fillInId(1)
                .clickSubmitButton();
    }
}
