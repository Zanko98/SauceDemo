package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {

    @Test
    public void orderingProduct() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        cartPage.open();
        cartPage.clickCheckoutButton();
        checkoutYourInformationPage.setYourInformation("Marina", "Makarevich", "220350");
        checkoutYourInformationPage.clickOnTheContinueButton();
        assertEquals(checkoutOverviewPage.getFinalPrice(), "$10.79");
        checkoutOverviewPage.clickFinishButton();
        assertEquals(checkoutCompletePage.getFinalMessage(), "THANK YOU FOR YOUR ORDER");
        checkoutCompletePage.clickBackHomeButton();
        assertEquals(headerContainerPage.getNameHeadPage(), "PRODUCTS");
    }
}
