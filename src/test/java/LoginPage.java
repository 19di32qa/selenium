import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
    private WebDriver driver;
    private WebElement element;
    public WebDriver setUpDriver(WebDriver driver){
        return this.driver = driver;
    }
    private void openPage() {
        driver.navigate().to("https://www.saucedemo.com/");
    }

    private  WebElement getUserNameField() {
        return element = driver.findElement(By.cssSelector("#user-name"));
    }
    private WebElement getPasswordField() {
        return element = driver.findElement(By.cssSelector("#password"));
    }
    private  WebElement getLoginButton() {
        return element = driver.findElement(By.cssSelector("#login-button"));
    }

    private void sendKeysUserName(String str) {
        element =  getUserNameField();
        element.sendKeys(str);
    }
    private   void sendPassword(String str) {
        element = getPasswordField();
        element.sendKeys(str);
    }
    private  void clickLogin() {
        element = getLoginButton();
        element.click();
    }
    public void login(String name, String password) {
        openPage();
        sendKeysUserName(name);
        sendPassword(password);
        clickLogin();
        //driver.quit();
    }


}
