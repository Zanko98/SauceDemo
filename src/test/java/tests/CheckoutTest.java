package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkingSortingByNameAToZ() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.sort("Name (A to Z)");
        assertEquals(productsPage.getNameElementByNumber(1), "Sauce Labs Backpack");
        assertEquals(productsPage.getNameElementByNumber(6), "Test.allTheThings() T-Shirt (Red)");
    }

    @Test
    public void checkingSortingByPriceLowToHigh() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.sort("Price (low to high)");
        assertEquals(productsPage.getNameElementByNumber(1), "Sauce Labs Onesie");
        assertEquals(productsPage.getNameElementByNumber(6), "Sauce Labs Fleece Jacket");
    }

    @Test
    public void checkoutTest() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        cartPage.open();
        cartPage.checkout("Marina", "Makarevich", "220350");
        assertEquals(cartPage.getFinalPrice(), "$64.78");
        assertEquals(cartPage.gettingTheResultMessage(), "THANK YOU FOR YOUR ORDER");
    }

}
