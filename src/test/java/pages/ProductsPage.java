package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductsPage extends BasePage {

    String addToCartButton = "//div[text()='%s']/ancestor::div[@class='inventory_item']//button[text()='Add to cart']",
            removeButton = "//div[text()='%s']/ancestor::div[@class='inventory_item']//button[text()='Remove']";
    By sort = By.cssSelector(".product_sort_container");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void open(int i) {
        driver.get(baseUrl + "/inventory.html");
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
        List<WebElement> element = driver.findElements(By.cssSelector(".inventory_item_name"));
        return element.get(numberProduct).getText();
    }

    public String getPriceElementByNumber(int numberProduct) {
        List<WebElement> element = driver.findElements(By.cssSelector(".inventory_item_price"));
        return element.get(numberProduct).getText();
    }
}