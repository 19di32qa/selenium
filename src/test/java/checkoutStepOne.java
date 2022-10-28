import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class checkoutStepOne {
    private WebDriver driver;
    private WebElement element;
    public WebDriver setUpDriver(WebDriver driver){
        return this.driver = driver;
    }
    private WebElement  getFirstName() {
        return element = driver.findElement(By.xpath("//*[@id=\"first-name\"]"));

    }
    private WebElement getLastName() {
        return element = driver.findElement(By.xpath("//*[@id=\"last-name\"]"));
    }
    private WebElement getZipCode() {
        return  element = driver.findElement(By.cssSelector("[data-test=\"postalCode\"]"));
    }
    private WebElement getContinueButton() {
        return element = driver.findElement(By.cssSelector("#continue"));
    }
    public   void  sendKeysFirstName(String str) {
        element = getFirstName();
        element.sendKeys(str);
    }
    public void sendKeysLasName(String str) {
        element = getLastName();
        element.sendKeys(str);
    }
    public   void sendKeysZipCode(String str) {
        element = getZipCode();
        element.sendKeys(str);
    }
    public void continueBtn(String fname, String lName, String zip) {
        sendKeysFirstName(fname);
        sendKeysLasName(lName);
        sendKeysZipCode(zip);
        element = getContinueButton();
        element.submit();
    }

}
