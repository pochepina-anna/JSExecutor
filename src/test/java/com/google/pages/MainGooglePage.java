package com.google.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Класс <class>MainGooglePage</class>
 */

public class MainGooglePage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[@id='lst-ib']")
    private WebElement findInput;

    @FindBy(xpath = "//*[@id='tsbb']")
    private WebElement findButton;

    public MainGooglePage(WebDriver driver){
        PageFactory.initElements(this.driver,this);
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 10);
    }

    public void setFindInput(String find){
        wait.until(ExpectedConditions.visibilityOf(findInput));
        findInput.clear();
        findInput.sendKeys(find);
    }

    public String getAttributeFindInput(String attr){
        wait.until(ExpectedConditions.visibilityOf(findInput));
        return findInput.getAttribute(attr);
    }

    public void blurFindInput(){
        ((JavascriptExecutor)driver).executeScript(".blur();",findInput);
    }

    public void findButtonClick(){
        wait.until(ExpectedConditions.elementToBeClickable(findButton)).click();
    }


}
