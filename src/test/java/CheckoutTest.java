import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckoutTest extends Basetest {

    @Test
    public void checkout() {
        String productLocator = "//div[text()='%s']/ancestor::div[@class='inventory_item']//button[text()='Add to cart']";

        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("user-name")).submit();
        driver.findElement(By.xpath(String.format(productLocator, "Sauce Labs Backpack"))).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("Dmitry");
        driver.findElement(By.id("last-name")).sendKeys("Rak");
        driver.findElement(By.id("postal-code")).sendKeys("222073");
        driver.findElement(By.id("continue")).click();
        String totalPrice = driver.findElement(By.cssSelector(".summary_total_label")).getText();
        assertTrue(driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).isDisplayed());
        assertEquals(totalPrice.split(" ")[1], "$32.39");
        driver.findElement(By.id("finish")).click();
        assertEquals(driver.findElement(By.cssSelector(".complete-header")).getText(), "THANK YOU FOR YOUR ORDER");
        driver.findElement(By.id("back-to-products")).click();
        assertTrue(driver.findElement(By.xpath("//span[text()='Products']")).isDisplayed());
    }
}
