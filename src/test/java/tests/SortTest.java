package tests;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;


public class SortTest extends BaseTest {

    public void checkingSorting(String sorting, String firstNameProduct, String lastNameProduct) {
        loginPage.open();
        loginPage.login(NAME, "secret_sauce");
        productsPage.sort(sorting);
        assertEquals(productsPage.getNameElementByNumber(5), firstNameProduct);
        assertEquals(productsPage.getNameElementByNumber(0), lastNameProduct);
    }

    @Test
    public void checkingSortingByNameZToA() {
        checkingSorting("Name (Z to A)", "Sauce Labs Backpack", "Test.allTheThings() T-Shirt (Red)");
    }

    @Test
    public void checkingSortingByPriceHighToLow() {
        checkingSorting("Price (high to low)", "Sauce Labs Onesie", "Sauce Labs Fleece Jacket");
    }

    @Test
    public void checkingSortingByPriceLowToHigh() {
        checkingSorting("Price (low to high)", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie");
    }

    @Test
    public void checkingSortingByNameAToZ() {
        checkingSorting("Name (A to Z)", "Test.allTheThings() T-Shirt (Red)", "Sauce Labs Backpack");
    }
}
