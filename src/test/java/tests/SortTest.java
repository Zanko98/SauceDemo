package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;


public class SortTest extends BaseTest {

    @DataProvider(name = "Входные данные для проверки сортировки")
    public Object[][] inputFor() {
        return new Object[][]{
                {"Name (Z to A)", "Sauce Labs Backpack", "Test.allTheThings() T-Shirt (Red)"},
                {"Price (high to low)", "Sauce Labs Onesie", "Sauce Labs Fleece Jacket"},
                {"Price (low to high)", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie"},
                {"Name (A to Z)", "Test.allTheThings() T-Shirt (Red)", "Sauce Labs Backpack"}
        };
    }

    @Test(dataProvider = "Входные данные для проверки сортировки", description = "Проверка сортировки товаров")
    public void checkingSorting(String sorting, String firstNameProduct, String lastNameProduct) {
        loginPage.open();
        loginPage.login(NAME, "secret_sauce");
        productsPage.sort(sorting);
        assertEquals(productsPage.getNameElementByNumber(5), firstNameProduct);
        assertEquals(productsPage.getNameElementByNumber(0), lastNameProduct);
    }
}
