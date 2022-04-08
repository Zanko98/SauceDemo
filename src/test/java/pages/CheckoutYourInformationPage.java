package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutYourInformationPage extends BasePage {
    public static final By FIRST_NAME = By.id("first-name"),
            LAST_NAME = By.id("last-name"),
            ZIP_CODE = By.id("postal-code"),
            ERROR_MESSAGE = By.xpath("//div[@class='error-message-container error']/h3"),
            CONTINUE_BUTTON = By.id("continue"),
            CANCEL_BUTTON = By.id("cancel");

    public CheckoutYourInformationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Filling in data fields firstName: {firstName}, lastName: {lastName}, zipCode: {zipCode}")
    public void setYourInformation(String firstName, String lastName, String zipCode) {
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        driver.findElement(LAST_NAME).sendKeys(lastName);
        driver.findElement(ZIP_CODE).sendKeys(zipCode);
    }

    @Step("Getting error message")
    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    @Step("click on the Continue button")
    public void clickOnTheContinueButton() {
        driver.findElement(CONTINUE_BUTTON).click();
    }

    @Step("click on the Cancel button")
    public void clickOnCancelButton() {
        driver.findElement(CANCEL_BUTTON).click();
    }

}
