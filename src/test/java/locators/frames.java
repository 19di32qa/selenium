package locators;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class frames {
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
    public void frames () {
        driver.navigate().to("https://the-internet.herokuapp.com/nested_frames");

        element = driver.findElement(By.name("frame-top"));

        driver.switchTo().frame(1);
        Assert.assertEquals("BOTTOM", driver.findElement(By.tagName("body")).getText());

        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");

        Assert.assertEquals("LEFT",driver.findElement(By.tagName("body")).getText());

        driver.switchTo().defaultContent();





    }

}
