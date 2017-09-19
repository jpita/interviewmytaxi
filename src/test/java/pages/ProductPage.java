package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by josepita on 19/09/2017.
 */
public class ProductPage extends BasePage{

    @FindBy(id = "AddToCart-product-template")
    private WebElement addToCartButton;

    private final String productName;

    public ProductPage(WebDriver driver, String productName) {
        super(driver);
        this.productName = productName;
        isLoaded();
    }

    @Override
    public boolean isLoaded() {
        return waitForElementToBeVisibleWithTimeOut(driver.findElement(By.xpath("//nav[@class='breadcrumb']/span[text()='"+productName+"']")), 5).isDisplayed();
    }

    public void addToCart() {
        saveCartCount();
        addToCartButton.click();
    }

    public Boolean wasProductAddedToCartSuccessfully(String productName){
        addToCart();
        CartPage cartPage = new CartPage(driver);
        return verify1ProductWasAddedToTheCart()&&new CartPage(driver).isProductPresentOnCart(productName);
    }

}
