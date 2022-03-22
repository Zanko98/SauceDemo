package pages;

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

    public void open(int i) {
        driver.get(baseUrl + "/inventory.html");
        wait.until(ExpectedConditions.numberOfElementsToBe(ELEMENT, 6));
    }

    public void addToCart(String product) {
        driver.findElement(By.xpath(String.format(addToCartButton, product))).click();
    }

    public void removeCart(String product) {
        driver.findElement(By.xpath(String.format(removeButton, product))).click();
    }

    public void sort(String sorting) {
        WebElement sortingElement = driver.findElement(sort);
        new Select(sortingElement).selectByVisibleText(sorting);
    }

    public String getNameElementByNumber(int numberProduct) {
        List<WebElement> element = driver.findElements(PRODUCT_NAME);
        return element.get(numberProduct).getText();
    }

    public String getPriceElementByNumber(int numberProduct) {
        List<WebElement> element = driver.findElements(PRODUCT_PRICE);
        return element.get(numberProduct).getText();
    }
}