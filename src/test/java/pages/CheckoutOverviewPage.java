package pages;

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

    public String getFinalPrice() {
        return driver.findElement(FINAL_PRICE).getText().split(" ")[1];
    }

    public String getSippingInformation() {
        return driver.findElement(SHIPPING_INFORMATION).getText();
    }

    public void clickFinishButton() {
        driver.findElement(FINISH_BUTTON).click();
    }

    public void clickCancelButton() {
        driver.findElement(CANCEL_BUTTON).click();
    }
}
