package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage extends BasePage {
    public static final By RESET_APP_STATE_BUTTON = By.id("reset_sidebar_link"),
            LOGOUT_BUTTON = By.id("logout_sidebar_link"),
            ALL_ITEMS_BUTTON = By.id("inventory_sidebar_link");

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    @Step("click on the {nameButton} button")
    public void clickButton(By nameButton) {
        driver.findElement(nameButton).click();
    }
}
