package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by josepita on 13/08/2017.
 */
public class LandingPage extends BasePage {

    @FindBy(css = "div.slideshow-carousel.flickity-enabled.is-draggable")
    private WebElement imageSliderCarouselPanel;

    @FindBy(id = "CartButton")
    private WebElement cartButton;

    @FindBy(xpath = "//nav[@class='nav-bar']//a[@href='/'][text()='Catalog']")
    private WebElement catalogDropdown;

    public LandingPage(WebDriver driver) {
        super(driver);
        isLoaded();
    }

    @Override
    public boolean isLoaded() {
        waitForElementToBeVisibleWithTimeOut(imageSliderCarouselPanel,5);
        return imageSliderCarouselPanel.isDisplayed();
    }

    public CartPage goToCartPage(){
        cartButton.click();
        waitForElementToNotBeVisibleWithElement(imageSliderCarouselPanel, 5);
        return new CartPage(driver);
    }

    public CatalogPage goToCatalogPage(String catalogName) {
        action.moveToElement(catalogDropdown).perform();
        driver.findElement(By.xpath("//nav[@class='nav-bar']//li[@role='menuitem']/a[text()='"+catalogName+"']")).click();
        waitForElementToBeVisible(driver.findElement(By.xpath("//nav[@class='breadcrumb']/span[text()='"+catalogName+"']")));
        return new CatalogPage(driver);
    }
}
