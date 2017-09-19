package tests;

import org.testng.annotations.Test;
import pages.CartPage;
import pages.CatalogPage;
import pages.LandingPage;
import pages.ProductPage;

import static org.testng.Assert.assertTrue;

public class AddProductsToCartTest extends BaseTest{

    @Test(description = "test that we can add one product and the cart page offer to the cart")
    public void add1ProductAndCartPageOfferTest(){
        LandingPage landingPage = new LandingPage(driver);
        assertTrue(landingPage.isLoaded(), "landing page not loaded");
        CatalogPage catalogPage = landingPage.goToCatalogPage("Materia Basics");
        ProductPage productPage = catalogPage.goToProductPageByName("Density Black");
        assertTrue(productPage.wasProductAddedToCartSuccessfully("Density Black"), "product was not added to cart successfully");
        assertTrue(new CartPage(driver).wasCartPageOfferAddedSuccessfully(), "product was not added to cart successfully");
    }

    @Test(description = "test that we can add two products to the cart")
    public void add2ProductsToTheCartTest(){
        LandingPage landingPage = new LandingPage(driver);
        assertTrue(landingPage.isLoaded(), "landing page not loaded");
        CatalogPage catalogPage = landingPage.goToCatalogPage("Materia Basics");
        ProductPage productPage = catalogPage.goToProductPageByName("Density Black");
        assertTrue(productPage.wasProductAddedToCartSuccessfully("Density Black"), "product was not added to cart successfully");
        catalogPage = landingPage.goToCatalogPage("Atom Basics");
        productPage = catalogPage.goToProductPageByName("Eternal Grape");
        assertTrue(productPage.wasProductAddedToCartSuccessfully("Eternal Grape"), "product was not added to cart successfully");
    }
}