import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends Basetest{

    public void login(String login, String password, String error){
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys(login);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("user-name")).submit();
        WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));
        assertEquals(errorMessage.getText(), error);
        assertTrue(errorMessage.isDisplayed());
    }

    @Test
    public void lockedOutUser() {
        login("locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void unregisteredUser() {
        login("Marina", "secret_sauce", "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void loginNotEntered() {
        login("", "secret_sauce", "Epic sadface: Username is required");
    }

    @Test
    public void passwordNotEntered() {
        login("locked_out_user", "", "Epic sadface: Password is required");
    }
}
