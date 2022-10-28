import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    private WebDriver driver;
    private WebElement element;
    public WebDriver setUpDriver(WebDriver driver){
        return this.driver = driver;
    }
    private WebElement getCheckoutButton() {
        return element = driver.findElement(By.cssSelector("#checkout"));
    }
    private WebElement getContinueShoppingButton() {
        return element = driver.findElement(By.xpath("//*[@id=\"continue-shopping\"]"));
    }
    public void checkoutButtonClick() {
        element = getCheckoutButton();
        element.click();
    }
    public void continueShoppingButton() {
        element = getContinueShoppingButton();
        element.click();
    }
}
