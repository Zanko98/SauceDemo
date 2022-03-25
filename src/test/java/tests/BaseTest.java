package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.*;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static final String NAME = "standard_user";

    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutCompletePage checkoutCompletePage;
    CheckoutOverviewPage checkoutOverviewPage;
    CheckoutYourInformationPage checkoutYourInformationPage;
    ProductPage productPage;
    MenuPage menuPage;
    HeaderContainerPage headerContainerPage;

    @Parameters({"browser"})
    @BeforeMethod
    public void setup(@Optional("chrome") String browser) throws MalformedURLException {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("safari")) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutYourInformationPage = new CheckoutYourInformationPage(driver);
        productPage = new ProductPage(driver);
        menuPage = new MenuPage(driver);
        headerContainerPage = new HeaderContainerPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        driver.quit();
    }
}