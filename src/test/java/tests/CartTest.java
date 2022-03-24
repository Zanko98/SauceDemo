package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CartTest extends BaseTest {

    @Test(description = "Проверка добавления продукта в корзину")
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

    @Test(description = "Проверка удаления продукта из корзины")
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

    @Test(description = "Проверка кнопки \"Continue\" в корзине")
    public void continueShoppingButtonTest() {
        loginPage.open();
        loginPage.login(NAME, "secret_sauce");
        cartPage.open();
        cartPage.clickContinueShoppingButton();
        assertEquals(headerContainerPage.getNameHeadPage(), "PRODUCTS");
    }

    @Test(description = "Проверка кнопки \"Checkout\" в корзине")
    public void checkoutButtonTest() {
        loginPage.open();
        loginPage.login(NAME, "secret_sauce");
        cartPage.open();
        cartPage.clickCheckoutButton();
        assertEquals(headerContainerPage.getNameHeadPage(), "CHECKOUT: YOUR INFORMATION");
    }
}