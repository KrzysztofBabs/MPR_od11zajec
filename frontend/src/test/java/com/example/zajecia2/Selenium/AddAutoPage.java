package com.example.zajecia2.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddAutoPage {
    private WebDriver webDriver;


    @FindBy(id="model")
    private WebElement modelInput;

    @FindBy(id="rokP")
    private WebElement rokProdukcjiInput;

    @FindBy(id="submit")
    private WebElement submitButton;

    public AddAutoPage(WebDriver webdriver) {
        this.webDriver = webdriver;
        PageFactory.initElements(webdriver, this); //wazne!
    }

    public AddAutoPage open(){
        this.webDriver.get("http://localhost:8080/view/add");
        return this;
    }

    public AddAutoPage fillInModelInput(String text){
        this.modelInput.sendKeys(text);
        return this;
    }

    public AddAutoPage fillInRokProdukcjiInput(int text){
        this.rokProdukcjiInput.clear(); // zeby usunac to zero na koncu
        this.rokProdukcjiInput.sendKeys(String.valueOf(text));
        return this;
    }
    public AddAutoPage clickSubmitButton(){
        this.submitButton.click();
        return this;
    }







}
