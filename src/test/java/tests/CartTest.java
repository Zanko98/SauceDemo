package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CartTest extends BaseTest {

    @Test
    public void productsShouldBeAddedIntoCart() {
        loginPage.open();
        loginPage.login(NAME, "secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        cartPage.open();
        assertTrue(cartPage.checkProductInCart("Sauce Labs Fleece Jacket"));
        assertEquals(cartPage.getCountElement(), 2);
        assertEquals(cartPage.getPrice("Sauce Labs Bike Light"), "$9.99");
    }

    @Test
    public void productShouldBeRemoveIntoCart() {
        loginPage.open();
        loginPage.login(NAME, "secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        cartPage.open();
        cartPage.removeProductFromTheCart("Sauce Labs Bike Light");
        assertFalse(cartPage.checkProductInCart("Sauce Labs Bike Light"));
        assertEquals(cartPage.getCountElement(), 1);
    }

    @Test
    public void continueShoppingButtonTest() {
        loginPage.open();
        loginPage.login(NAME, "secret_sauce");
        cartPage.open();
        cartPage.clickContinueShoppingButton();
        assertEquals(headerContainerPage.getNameHeadPage(), "PRODUCTS");
    }

    @Test
    public void checkoutButtonTest() {
        loginPage.open();
        loginPage.login(NAME, "secret_sauce");
        cartPage.open();
        cartPage.clickCheckoutButton();
        assertEquals(headerContainerPage.getNameHeadPage(), "CHECKOUT: YOUR INFORMATION");
    }
}