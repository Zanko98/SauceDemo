package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class CheckoutYourInformationTest extends BaseTest {

    @DataProvider(name = "Входящие данные для негативных тестов на формы YourInformation")
    public Object[][] inputForFieldsYourInformationShouldNotBeEmptyTest() {
        return new Object[][]{
                {"", "a", "a", "Error: First Name is required"},
                {"a", "", "a", "Error: Last Name is required"},
                {"a", "a", "", "Error: Postal Code is required"}
        };
    }

    @Test(dataProvider = "Входящие данные для негативных тестов на формы YourInformation")
    public void FieldsYourInformationShouldNotBeEmpty(String firstName, String lastName, String zipCode, String error) {
        loginPage.open();
        loginPage.login(NAME, "secret_sauce");
        cartPage.open();
        cartPage.clickCheckoutButton();
        checkoutYourInformationPage.setYourInformation(firstName, lastName, zipCode);
        checkoutYourInformationPage.clickOnTheContinueButton();
        assertEquals(checkoutYourInformationPage.getErrorMessage(), error);
    }

    @Test(description = "Проверка кнопки \"Continue\" на странице \"CHECKOUT: YOUR INFORMATION\"")
    public void continueButtonTest() {
        loginPage.open();
        loginPage.login(NAME, "secret_sauce");
        cartPage.open();
        cartPage.clickCheckoutButton();
        checkoutYourInformationPage.setYourInformation("a", "a", "a");
        checkoutYourInformationPage.clickOnTheContinueButton();
        assertEquals(headerContainerPage.getNameHeadPage(), "CHECKOUT: OVERVIEW");
    }
}
