package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartTest extends BaseTest {

    @Test
    public void productShouldBeAddedIntoCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        cartPage.open();
        assertTrue(cartPage.checkingTheProductInTheCart("Sauce Labs Bike Light"));
        assertEquals(cartPage.getPrice("Sauce Labs Bike Light"), "$9.99");
    }

    @Test
    public void productShouldBeRemoveIntoCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        cartPage.open();
        cartPage.removeProductFromTheCart("Sauce Labs Bike Light");
        assertTrue(cartPage.checkingTheRemovalOfTheProduct("Sauce Labs Bike Light"));
    }

}