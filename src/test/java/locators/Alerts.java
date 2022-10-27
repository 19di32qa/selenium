package locators;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {
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
    public void testAlert() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button")).click();
        driver.switchTo().alert().dismiss();

        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button")).click();
        driver.switchTo().alert().accept();

        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click();
        //driver.switchTo().alert().sendKeys("Text");
        Alert al = driver.switchTo().alert();
        al.sendKeys("more text");
        //driver.switchTo().alert().accept();
        al.accept();

    }
}
