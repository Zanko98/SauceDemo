package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage {
    public static final By FINAL_MESSAGE = By.cssSelector(".complete-header"),
            BACK_HOME_BUTTON = By.id("back-to-products");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    @Step("Getting final message")
    public String getFinalMessage() {
        return driver.findElement(FINAL_MESSAGE).getText();
    }

    @Step("click on the Back Home button")
    public void clickBackHomeButton() {
        driver.findElement(BACK_HOME_BUTTON).click();
    }
}
