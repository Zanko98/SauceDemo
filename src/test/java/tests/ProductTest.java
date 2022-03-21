package tests;

import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;

public class ProductTest extends BaseTest{

    @Test
    public void addToCartButton(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productPage.open(1);
        assertEquals(productPage.getProductName(), "Sauce Labs Bolt T-Shirt");
        assertEquals(productPage.getProductPrice(), "$15.99");
        productPage.clickAddToCartButton();
        assertEquals(headerContainerPage.getCountProductInCart(), "1");
        productPage.clickOnTheRemoveButton();
        assertFalse(headerContainerPage.checkingTheDisplayOfCountProductOnCartBadge());
    }
}
