package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductsPage extends BasePage {

    String addToCartButton = "//div[text()='%s']/ancestor::div[@class='inventory_item']//button[text()='Add to cart']",
            removeButton = "//div[text()='%s']/ancestor::div[@class='inventory_item']//button[text()='Remove']";
    By sort = By.cssSelector(".product_sort_container"),
            ELEMENT = By.cssSelector(".inventory_item_name"),
            PRODUCT_PRICE = By.cssSelector(".inventory_item_price"),
            PRODUCT_NAME = By.cssSelector(".inventory_item_name");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening the products page")
    public void open() {
        driver.get(baseUrl + "/inventory.html");
        wait.until(ExpectedConditions.numberOfElementsToBe(ELEMENT, 6));
    }

    @Step("Adding a {product} product to the cart")
    public void addToCart(String product) {
        driver.findElement(By.xpath(String.format(addToCartButton, product))).click();
    }

    @Step("Removing a {product} product from the cart")
    public void removeCart(String product) {
        driver.findElement(By.xpath(String.format(removeButton, product))).click();
    }

    @Step("doing {sorting} sorting")
    public void sort(String sorting) {
        WebElement sortingElement = driver.findElement(sort);
        new Select(sortingElement).selectByVisibleText(sorting);
    }

    @Step("Getting the element name by number {numberProduct}")
    public String getNameElementByNumber(int numberProduct) {
        List<WebElement> element = driver.findElements(PRODUCT_NAME);
        return element.get(numberProduct).getText();
    }

    @Step("Getting the element price by number {numberProduct}")
    public String getPriceElementByNumber(int numberProduct) {
        List<WebElement> element = driver.findElements(PRODUCT_PRICE);
        return element.get(numberProduct).getText();
    }
}