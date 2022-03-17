package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CartPage extends BasePage {
    String productInTheCartLocator = "//div[text()='%s']";
    String priceInTheCartLocator = "//div[text()='%s']/ancestor::div[@class='cart_item_label']//div[@class='inventory_item_price']";
    By checkoutButton = By.id("checkout");
    By finishButton = By.id("finish");
    String removeButtonLocator = "//div[text()='%s']/ancestor::div[@class='cart_item_label']//button";
    By firstNameLocator = By.id("first-name"),
            lastNameLocator = By.id("last-name"),
            zipCodeLocator = By.id("postal-code"),
            continueButton = By.id("continue");
    By finalPriceLocator = By.cssSelector(".summary_total_label");
    By finalMessage = By.cssSelector(".complete-header");


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(baseUrl + "/cart.html");
    }

    public void removeProductFromTheCart(String nameProduct) {
        driver.findElement(By.xpath(String.format(removeButtonLocator, nameProduct))).click();
    }

    public String getPrice(String nameProduct) {
        return driver.findElement(By.xpath(String.format(priceInTheCartLocator, nameProduct))).getText();
    }

    public boolean checkingTheProductInTheCart(String nameProduct) {
        return driver.findElement(By.xpath(String.format(productInTheCartLocator, nameProduct))).isDisplayed();
    }

    public boolean checkingTheRemovalOfTheProduct(String nameProduct) {
        int c = driver.findElements(By.xpath(String.format(productInTheCartLocator, nameProduct))).size();
        return c == 0 ? true : false;
    }

    public void checkout(String firstName, String lastName, String zipCode) {
        driver.findElement(checkoutButton).click();
        driver.findElement(firstNameLocator).sendKeys(firstName);
        driver.findElement(lastNameLocator).sendKeys(lastName);
        driver.findElement(zipCodeLocator).sendKeys(zipCode);
        driver.findElement(continueButton).click();
    }

    public String getFinalPrice() {
        return driver.findElement(finalPriceLocator).getText().split(" ")[1];
    }

    public String gettingTheResultMessage() {
        driver.findElement(finishButton).click();
        return driver.findElement(finalMessage).getText();
    }


}
