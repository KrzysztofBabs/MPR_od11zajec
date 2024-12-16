package com.example.zajecia2.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateAutoPage {

    private WebDriver webDriver;

    @FindBy(id="id")
    private WebElement idInput;

    @FindBy(id="model")
    private WebElement modelInput;

    @FindBy(id="rokP")
    private WebElement rokProdukcjiInput;

    @FindBy(id="submit")
    private WebElement submitButton;

    public UpdateAutoPage(WebDriver webdriver) {
        this.webDriver = webdriver;
        PageFactory.initElements(webdriver, this); //wazne!
    }
    public UpdateAutoPage open(){
        this.webDriver.get("http://localhost:8080/view/update");
        return this;
    }

    public UpdateAutoPage fillInIdInput(int text){
        this.idInput.clear(); // zeby usunac to zero na koncu
        this.idInput.sendKeys(String.valueOf(text));
        return this;
    }


    public UpdateAutoPage fillInModelInput(String text){
        this.modelInput.sendKeys(text);
        return this;
    }

    public UpdateAutoPage fillInRokProdukcjiInput(int text){
        this.rokProdukcjiInput.clear(); // zeby usunac to zero na koncu
        this.rokProdukcjiInput.sendKeys(String.valueOf(text));
        return this;
    }
    public UpdateAutoPage clickSubmitButton(){
        this.submitButton.click();
        return this;
    }
}
