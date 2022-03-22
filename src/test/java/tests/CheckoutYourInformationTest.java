package tests;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class CheckoutYourInformationTest extends BaseTest {

    public void setFieldsAndCompareError(String firstName, String lastName, String zipCode) {
        loginPage.open();
        loginPage.login(NAME, "secret_sauce");
        cartPage.open();
        cartPage.clickCheckoutButton();
        checkoutYourInformationPage.setYourInformation(firstName, lastName, zipCode);
        checkoutYourInformationPage.clickOnTheContinueButton();
    }

    @Test
    public void firstNameShouldBeEmptyTest() {
        setFieldsAndCompareError("", "a", "a");
        assertEquals(checkoutYourInformationPage.getErrorMessage(), "Error: First Name is required");
    }

    @Test
    public void lastNameShouldBeEmptyTest() {
        setFieldsAndCompareError("a", "", "a");
        assertEquals(checkoutYourInformationPage.getErrorMessage(), "Error: Last Name is required");
    }

    @Test
    public void zipCodeShouldBeEmptyTest() {
        setFieldsAndCompareError("a", "a", "");
        assertEquals(checkoutYourInformationPage.getErrorMessage(), "Error: Postal Code is required");
    }

    @Test
    public void continueButtonTest() {
        setFieldsAndCompareError("a", "a", "a");
        assertEquals(headerContainerPage.getNameHeadPage(), "CHECKOUT: OVERVIEW");
    }
}
