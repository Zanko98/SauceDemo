package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;


public class HeaderContainerPage extends BasePage {
    public static final By NAME_HEAD_PAGE = By.xpath("//span[@class='title']"),
            MENU_BUTTON = By.id("react-burger-menu-btn"),
            CART_BUTTON = By.cssSelector(".shopping_cart_link"),
            NUMBER_PRODUCTS_IN_CART = By.cssSelector(".shopping_cart_badge"),
            BACK_TO_PRODUCTS_BUTTON = By.id("back-to-products");

    public HeaderContainerPage(WebDriver driver) {
        super(driver);
    }

    @Step("Getting the amount of products on the cart icon")
    public String getCountProductInCart() {
        return driver.findElement(NUMBER_PRODUCTS_IN_CART).getText();
    }

    @Step("Getting name head page")
    public String getNameHeadPage() {
        return driver.findElement(NAME_HEAD_PAGE).getText();
    }

    @Step("click on the Cart button")
    public void clickOnCartButton() {
        driver.findElement(CART_BUTTON).click();
    }

    @Step("click on the Menu button")
    public void clickMenuButton() {
        driver.findElement(MENU_BUTTON).click();
    }

    @Step("click on the Back to products button")
    public void clickOnBackToProductsButton() {
        driver.findElement(BACK_TO_PRODUCTS_BUTTON).click();
    }

    @Step("checking the display of the number of products on the basket icon")
    public boolean checkingTheDisplayOfCountProductOnCartBadge() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        int numberOfElements = driver.findElements(NUMBER_PRODUCTS_IN_CART).size();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return numberOfElements != 0;
    }

}
