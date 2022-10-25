

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Exercise1Test {
    static WebDriver driver;
    WebElement element;
    @BeforeAll

    public static void setUp() {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterAll
    public static void tearDown() throws Exception {
        driver.quit();
    }

    @org.junit.jupiter.api.Test
    public void testSelectedOption() {
//        driver.get("https://the-internet.herokuapp.com/dropdown");
//        driver.findElement(By.cssSelector("#dropdown")).click();
//        driver.findElement(By.cssSelector("[value=\"1\"]")).click();
//        Assert.assertFalse(driver.findElement(By.cssSelector("[value=\"2\"]")).isSelected());
//        Assert.assertTrue((driver.findElement(By.cssSelector("[value=\"1\"]")).isSelected()));
        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.findElement(By.cssSelector("#dropdown")).click();
        WebElement option1 = driver.findElement(By.cssSelector("[value=\"1\"]"));
        WebElement option2 = driver.findElement(By.cssSelector("[value=\"2\"]"));
        option1.click();
        Assert.assertTrue(option1.isSelected());
        Assert.assertFalse(option2.isSelected());
    }

    @org.junit.jupiter.api.Test
    public void testHover() {
        driver.get("https://the-internet.herokuapp.com/hovers");
        Actions action = new Actions(driver);
        element = driver.findElement(By.cssSelector(".row:nth-child(2)"));
        WebElement target = driver.findElement(By.cssSelector(".figure:first-of-type"));
        action.moveToElement(target).build().perform();
        WebElement elem2 = driver.findElement(By.cssSelector(".figure:first-of-type h5"));
        //String str = elem2.getText();
        //System.out.println(str.equals("name: user1"));
        Assert.assertTrue(elem2.getText().equals("name: user1"));
        Assert.assertTrue(elem2.isDisplayed());
    }
    @org.junit.jupiter.api.Test
    public void testContextMenuAndAlert() {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        element = driver.findElement(By.cssSelector("#hot-spot"));
        Actions action = new Actions(driver);
        action.contextClick(element).build().perform();

        driver.switchTo().alert().accept();
    }
    @org.junit.jupiter.api.Test
    public void testKeyEnter() {
        driver.get("https://the-internet.herokuapp.com/key_presses");
        element = driver.findElement(By.cssSelector("#target"));
        Actions action = new Actions(driver);
        action.sendKeys(element, Keys.ARROW_RIGHT).build().perform();
        WebElement elem2 = driver.findElement(By.id("result"));
        boolean res = checkString(elem2.getText(), "RIGHT");
        Assert.assertTrue(res);

    }
    public boolean checkString(String str1, String str2) {
        if (str1.indexOf(str2) != -1) {
            return true;
        }
        return false;
    }
    @Test
    public void checkAttributes() {
        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
        element = driver.findElement(By.cssSelector("[href=\"/link-success/\"]"));
        Assert.assertTrue(element.getAttribute("href").equals("https://ultimateqa.com/link-success/"));
        Assert.assertTrue(element.getCssValue("background-origin").equals("padding-box"));
    }
}
