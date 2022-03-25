package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @DataProvider(name = "Входящие данные для негативных тестов на логин")
    public Object[][] loginDate() {
        return new Object[][]{
                {"test", "", "Epic sadface: Password is required"},
                {"", "test", "Epic sadface: Username is required"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"Marina", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test(dataProvider = "Входящие данные для негативных тестов на логин")
    public void test123(String name, String password, String error) {
        loginPage.open();
        loginPage.login(name, password);
        assertEquals(loginPage.getError(), error, "Сообщение об ошибке при логине некорректное");
    }
}