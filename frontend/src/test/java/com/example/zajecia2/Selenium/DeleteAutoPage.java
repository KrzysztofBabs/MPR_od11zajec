package com.example.zajecia2.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteAutoPage {

    private WebDriver webDriver;


    @FindBy(id="id")
    private WebElement idInput;

    @FindBy(id="submit")
    private WebElement submitButton;


    public DeleteAutoPage(WebDriver webdriver) {
        this.webDriver = webdriver;
        PageFactory.initElements(webdriver, this); //wazne!
    }

    public DeleteAutoPage open(){
        this.webDriver.get("http://localhost:8080/view/delete");
        return this;
    }

    public DeleteAutoPage fillInId(int text){
        this.idInput.clear(); // zeby usunac to zero na koncu
        this.idInput.sendKeys(String.valueOf(text));
        return this;
    }

    public DeleteAutoPage clickSubmitButton(){
        this.submitButton.click();
        return this;
    }
}
