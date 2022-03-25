package tests;

import org.testng.annotations.Test;
import pages.MenuPage;

import static org.testng.AssertJUnit.*;

public class HeaderContainerTest extends BaseTest {

    @Test(description = "Проверка кнопки меню \"Logout\"")
    public void logOutMenuButtonTest() {
        loginPage.open();
        loginPage.login(NAME, "secret_sauce");
        headerContainerPage.clickMenuButton();
        menuPage.clickButton(MenuPage.LOGOUT_BUTTON);
        assertTrue(loginPage.loginButtonShouldBeDisplayed());
    }

    @Test(description = "Проверка кнопки меню \"All Items\"")
    public void allItemsMenuButtonTest() {
        loginPage.open();
        loginPage.login(NAME, "secret_sauce");
        cartPage.open();
        headerContainerPage.clickMenuButton();
        menuPage.clickButton(MenuPage.ALL_ITEMS_BUTTON);
        assertEquals(headerContainerPage.getNameHeadPage(), "PRODUCTS");
    }

    @Test(description = "Проверка кнопки меню \"Reset App State\"")
    public void resetAppSateMenuButtonTest() {
        loginPage.open();
        loginPage.login(NAME, "secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        assertEquals(headerContainerPage.getCountProductInCart(), "2");
        productsPage.removeCart("Sauce Labs Fleece Jacket");
        assertEquals(headerContainerPage.getCountProductInCart(), "1");
        headerContainerPage.clickMenuButton();
        menuPage.clickButton(MenuPage.RESET_APP_STATE_BUTTON);
        assertFalse(headerContainerPage.checkingTheDisplayOfCountProductOnCartBadge());
    }

    @Test(description = "Проверка кликабельности иконки корзины в заголовке")
    public void shoppingCartButtonTest() {
        loginPage.open();
        loginPage.login(NAME, "secret_sauce");
        headerContainerPage.clickOnCartButton();
        assertEquals(headerContainerPage.getNameHeadPage(), "YOUR CART");
    }

    @Test(description = "Проверка кнопки \"Back to products\" на странице товара")
    public void backToProductButtonTest() {
        loginPage.open();
        loginPage.login(NAME, "secret_sauce");
        productPage.open(1);
        headerContainerPage.clickOnBackToProductsButton();
        assertEquals(headerContainerPage.getNameHeadPage(), "PRODUCTS");
    }
}
