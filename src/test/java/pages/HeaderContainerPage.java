package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class HeaderContainerPage extends BasePage {
    public static final By NAME_HEAD_PAGE = By.xpath("//span[@class='title']"),
            MENU_BUTTON = By.id("react-burger-menu-btn"),
            CART_BUTTON = By.cssSelector(".shopping_cart_link"),
            NUMBER_PRODUCTS_IN_CART = By.cssSelector(".shopping_cart_badge"),
            BACK_TO_PRODUCTS_BUTTON = By.id("back-to-products");

    public HeaderContainerPage(WebDriver driver) {
        super(driver);
    }

    public String getCountProductInCart() {
        return driver.findElement(NUMBER_PRODUCTS_IN_CART).getText();
    }

    public String getNameHeadPage() {
        return driver.findElement(NAME_HEAD_PAGE).getText();
    }

    public void clickOnCartButton() {
        driver.findElement(CART_BUTTON).click();
    }

    public void clickMenuButton() {
        driver.findElement(MENU_BUTTON).click();
    }

    public void clickOnBackToProductsButton() {
        driver.findElement(BACK_TO_PRODUCTS_BUTTON).click();
    }

    public boolean checkingTheDisplayOfCountProductOnCartBadge() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        int numberOfElements = driver.findElements(NUMBER_PRODUCTS_IN_CART).size();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return numberOfElements != 0;
    }

}
