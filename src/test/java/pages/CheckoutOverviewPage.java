package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage {
    public static final By FINISH_BUTTON = By.id("finish"),
            CANCEL_BUTTON = By.id("cancel"),
            FINAL_PRICE = By.cssSelector(".summary_total_label"),
            SHIPPING_INFORMATION = By.xpath("//div[@class='summary_value_label'][2]");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    @Step("Getting the final price of the order")
    public String getFinalPrice() {
        return driver.findElement(FINAL_PRICE).getText().split(" ")[1];
    }

    @Step("Getting the shipping information of the order")
    public String getSippingInformation() {
        return driver.findElement(SHIPPING_INFORMATION).getText();
    }

    @Step("click on the Finish button")
    public void clickFinishButton() {
        driver.findElement(FINISH_BUTTON).click();
    }

    @Step("click on the Cancel button")
    public void clickCancelButton() {
        driver.findElement(CANCEL_BUTTON).click();
    }
}
