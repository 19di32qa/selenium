import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShoppingCart {
    private WebDriver driver;
    private WebElement element;
    public WebDriver setUpDriver(WebDriver driver){
        return this.driver = driver;
    }

    private WebElement getShoppingCart() {
        return element = driver.findElement(By.cssSelector(".shopping_cart_link"));
    }
    public void openShoppingCart() {
        element = getShoppingCart();
        element.click();
    }

}
