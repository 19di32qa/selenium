import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class inventoryPageTest {
    static WebDriver driver;
    static WebElement element;
    @BeforeAll
    static void setUp() {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @AfterAll
    static void tearDown() {
        driver.quit();
    }
    @Test
    public void E2EInventory() {
        LoginPage loginPage = new LoginPage();
        ShoppingCart shoppingCart = new ShoppingCart();
        CartPage cartPage = new CartPage();
        checkoutStepOne cont = new checkoutStepOne();
        cont.setUpDriver(driver);
        cartPage.setUpDriver(driver);
        loginPage.setUpDriver(driver);
        shoppingCart.setUpDriver(driver);
        loginPage.login("standard_user","secret_sauce");
        shoppingCart.openShoppingCart();
        cartPage.checkoutButtonClick();
        cont.continueBtn("tst","ss","z");

    }
//    @Test public void testShoppingCart() {
//        ShoppingCart shoppingCart = new ShoppingCart();
//        shoppingCart.openShoppingCart();
//    }
}
