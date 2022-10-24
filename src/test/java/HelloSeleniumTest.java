import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class HelloSeleniumTest {
    @Test
    public void firstTest() {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.quit();
    }
    @Test
    public void edgeTest() {
        System.setProperty("webdriver.edge.driver","resources/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/");
    }
    @Test
    public void edgeTest2() {
        System.setProperty("webdriver.edge.driver","resources/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("https://example.cypress.io/");
       // driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
    }
    @Test
    public void edgeTest3() {
        System.setProperty("webdriver.edge.driver", "resources/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
    }

}
