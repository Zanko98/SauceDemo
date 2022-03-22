package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class CartPage extends BasePage {
    public static final By CHECKOUT_BUTTON = By.id("checkout"),
            CONTINUE_SHOPPING_BUTTON = By.id("continue-shopping"),
            PRODUCT_NAME = By.cssSelector(".inventory_item_name"),
            PRODUCT_LOCATOR = By.cssSelector(".cart_item");
    String productLocator = "//div[text()='%s']",
            priceLocator = "//div[text()='%s']/ancestor::div[@class='cart_item_label']//div[@class='inventory_item_price']",
            removeButtonLocator = "//div[text()='%s']/ancestor::div[@class='cart_item_label']//button";


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(baseUrl + "/cart.html");
        wait.until(ExpectedConditions.visibilityOfElementLocated(CHECKOUT_BUTTON));
    }

    public void removeProductFromTheCart(String nameProduct) {
        driver.findElement(By.xpath(String.format(removeButtonLocator, nameProduct))).click();
    }

    public String getPrice(String nameProduct) {
        return driver.findElement(By.xpath(String.format(priceLocator, nameProduct))).getText();
    }

    public int getCountElement() {
        List<WebElement> element = driver.findElements(PRODUCT_LOCATOR);
        return element.size();
    }

    public void clickCheckoutButton() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    public void clickContinueShoppingButton() {
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
    }

    public boolean checkProductInCart(String nameProduct) {
        List<WebElement> element = driver.findElements(PRODUCT_NAME);
        boolean contains = false;
        for (WebElement webElement : element) {
            if (webElement.getText().equals(nameProduct)) contains = true;
        }
        return contains;
    }
}
