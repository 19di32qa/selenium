import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class LocatingElements {
    @Test
    public void elemQuiz1() {

        //Where chromedriver is
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        //1)Instantiate driver
        WebDriver driver = new ChromeDriver();
        //2)Navigate to url
        driver.get("https://www.saucedemo.com/");
        //3)/4)find the element, check status
        WebDriverWait  wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user-name")));
        //5)/6)action ,record
        assertTrue(element.isDisplayed());
        //7)quit
        driver.quit();


    }



}
