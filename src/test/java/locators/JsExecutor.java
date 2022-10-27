package locators;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class JsExecutor {
    static WebDriver driver;
    static WebElement element;
    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
    @Test
    public void testWindowsFrames() {
        driver.navigate().to("https://the-internet.herokuapp.com/windows");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://the-internet.herokuapp.com/windows/new')");

        String originalWindow = driver.getWindowHandle();
        Set handlers = driver.getWindowHandles();
        handlers.remove(originalWindow);
        String nextWindow = String.valueOf(handlers.iterator().next());
        driver.switchTo().window(nextWindow);
        Assert.assertEquals("New Window",driver.getTitle());
        driver.close();
        driver.switchTo().window(originalWindow);
        Assert.assertEquals("The Internet",driver.getTitle());

    }


}
