package locators;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Date;

public class Cookies {
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
    public void addCookie() {
        driver.get("http://example.com");
        Cookie cookies = new Cookie.Builder("name","value").domain("example.com").expiresOn(new Date(2022,10,28)
        ).isHttpOnly(true).isSecure(false).path("/mypath").build();
        driver.manage().addCookie(cookies);
        driver.get("http://example.com/mypath");
        Cookie found = driver.manage().getCookieNamed("name");
        Assert.assertEquals("value",found.getValue());
        driver.manage().deleteAllCookies();
        Assert.assertFalse(driver.manage().getCookies().contains(found));
    }
}
