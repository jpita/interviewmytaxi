package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by josepita on 18/09/2017.
 */
public class CartPage extends BasePage {

    @FindBy(xpath = "//nav[@class='breadcrumb']/span[text()='Your Shopping Cart']")
    private WebElement navigationLabel;

    @FindBy(xpath = "//button[text()='Add to Cart']")
    private WebElement addToCartCartPageOfferButton;

    public CartPage(WebDriver driver) {
        super(driver);
        isLoaded();
    }

    @Override
    public boolean isLoaded() {
        waitForElementToBeVisibleWithTimeOut(navigationLabel,5);
        return navigationLabel.isDisplayed();
    }

    public Boolean wasCartPageOfferAddedSuccessfully(){
        saveCartCount();
        addToCartCartPageOfferButton.click();
        return verify1ProductWasAddedToTheCart();
    }

    public Boolean isProductPresentOnCart(String productName){
        return driver.findElement(By.xpath("//div[@class='cart-item-title']//a[contains(text(),'"+productName+"')]")).isDisplayed();
    }

}
