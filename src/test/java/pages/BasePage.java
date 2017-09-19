package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.BaseTest;

import java.util.Arrays;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

/**
 */
public class BasePage extends BaseTest{
    private WebDriverWait wait;
    protected Actions action;
    protected int cartCount;

    @FindBy(id = "CartCount")
    protected WebElement cartCountLabel;

    public BasePage(WebDriver driver){
        //in order to have the @FindBy elements being set, we need this line
        PageFactory.initElements(driver, this);
        this.driver = driver;
        action = new Actions(driver);
    }

    public boolean isLoaded() {
        return false;
    }

    protected void saveCartCount() {
        cartCount = Integer.parseInt(cartCountLabel.getText());
    }

    protected Boolean verify1ProductWasAddedToTheCart(){
        return Integer.parseInt(cartCountLabel.getText()) == cartCount+1;
    }





    protected WebElement waitForElementToBeVisible(WebElement element) {
        return waitForElementToBeVisibleWithTimeOut(element, 5);
    }

    protected void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected WebElement waitForElementToBeVisibleWithTimeOut(WebElement element, int seconds) {
        wait = new WebDriverWait(driver, seconds);
        return wait.until(visibilityOf(element));
    }

    protected Boolean waitForElementToNotBeVisibleWithTimeOut(By by, int seconds) {
        wait = new WebDriverWait(driver, seconds);
        return wait.until(invisibilityOfElementLocated(by));
    }

    protected Boolean waitForElementToNotBeVisibleWithElement(WebElement element, int seconds) {
        wait = new WebDriverWait(driver, seconds);
        return wait.until(invisibilityOfAllElements(Arrays.asList(element)));
    }


    protected Boolean waitForElementToNotBeVisible(By by) {
        return waitForElementToNotBeVisibleWithTimeOut(by, 5);
    }


    protected WebElement waitForElementToBeClickableWithTimeOut(By by, int seconds) {
        wait = new WebDriverWait(driver, seconds);
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    protected WebElement waitForElementToBeClickable(By by){
        return waitForElementToBeClickableWithTimeOut(by, 5);
    }
}
