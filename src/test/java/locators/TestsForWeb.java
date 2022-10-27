package locators;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestsForWeb {
    static WebDriver driver;
    static WebElement element;
    @BeforeAll
    static void setUp() {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @AfterAll
    static void tearDown() {
        driver.quit();
    }
    @Test
    public void testInput() {
        driver.get("https://example.cypress.io/commands/actions");
        element = driver.findElement(By.xpath("//*[@id=\"password1\"]"));
        element.click();
        System.out.println(element.getCssValue("color"));
        Assert.assertTrue(element.equals(driver.switchTo().activeElement()));
        Assert.assertEquals(element.getCssValue("color") , "rgba(85, 85, 85, 1)");
    }
    @Test
    public void testInput2() {
        driver.get("https://example.cypress.io/commands/actions");
        element = driver.findElement(By.xpath("//*[@id=\"password1\"]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('password1').focus();");
        Assert.assertTrue(element.equals(driver.switchTo().activeElement()));

    }
    @Test
    public void testCookies() {
        driver.get("https://example.cypress.io/commands/cookies");
        driver.findElement(By.xpath("//*[@id=\"getCookie\"]/div/div[2]/div/button")).click();
        Cookie cookie = driver.manage().getCookieNamed("token");
        Assert.assertEquals(cookie.getValue(), "123ABC");
    }
    @Test
    public void testScroll() throws InterruptedException {
        driver.get("https://ultimateqa.com/complicated-page/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight || document.documentElement.scrollHeight)");
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,-document.body.scrollHeight || -document.documentElement.scrollHeight)");
        Thread.sleep(1000);
    }

}
