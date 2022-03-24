package tests;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;

public class ProductTest extends BaseTest {

    @Test(description = "Проверка отображения информации о товаре и кликабельности кнопок \"Add to cart/Remove\" на странице товара")
    public void addToCartButton() {
        loginPage.open();
        loginPage.login(NAME, "secret_sauce");
        productPage.open(1);
        assertEquals(productPage.getProductName(), "Sauce Labs Bolt T-Shirt");
        assertEquals(productPage.getProductPrice(), "$15.99");
        productPage.clickAddToCartButton();
        assertEquals(headerContainerPage.getCountProductInCart(), "1");
        productPage.clickOnTheRemoveButton();
        assertFalse(headerContainerPage.checkingTheDisplayOfCountProductOnCartBadge());
    }
}
