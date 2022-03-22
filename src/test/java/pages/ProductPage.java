package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {

    public static final By PRODUCT_PRICE = By.cssSelector(".inventory_details_price"),
            PRODUCT_NAME = By.xpath("//div[@class='inventory_details_desc_container']/div"),
            PRODUCT_DESCRIPTION = By.xpath("//div[@class='inventory_details_desc_container']/div[2]"),
            REMOVE_BUTTON = By.xpath("//button[text()='Remove']"),
            ADD_TO_CART_BUTTON = By.xpath("//button[text()='Add to cart']");
    String linkProduct = "/inventory-item.html?id=";

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void open(int numberProduct) {
        driver.get(baseUrl + linkProduct + Integer.toString(numberProduct));
        wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_PRICE));
    }

    public String getProductPrice() {
        return driver.findElement(PRODUCT_PRICE).getText();
    }

    public String getProductName() {
        return driver.findElement(PRODUCT_NAME).getText();
    }

    public String getProductDescription() {
        return driver.findElement(PRODUCT_DESCRIPTION).getText();
    }

    public void clickOnTheRemoveButton() {
        driver.findElement(REMOVE_BUTTON).click();
    }

    public void clickAddToCartButton() {
        driver.findElement(ADD_TO_CART_BUTTON).click();
    }
}
