package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by josepita on 19/09/2017.
 */
public class CatalogPage extends BasePage{

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage goToProductPageByName(String productName){
        WebElement element = driver.findElement(By.xpath("//div[@class='box product']//img[@alt='"+productName+"']"));

        scrollToElement(element);

        element.click();
        return new ProductPage(driver, productName);
    }

}
