import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
    @Test
    public void Locator1() {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");
        //by id
        WebElement element = driver.findElement(By.id("user-name"));
        //by class
        driver.findElement(By.className("form_input"));
        // by tag
        driver.findElement(By.tagName("input"));
        //by css selector
        driver.findElement(By.cssSelector("#login-button"));
        //by Xpath
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div[2]"));
        //by link text
        //driver.findElement(By.linkText("LOGIN"));
        //System.out.println(element);
        driver.quit();
    }
}
