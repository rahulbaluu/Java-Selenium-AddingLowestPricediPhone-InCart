package ebay.user.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart() {
        // Handle tab switch if product opens in new tab
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }

        // Wait for Add to Cart button and click
        WebElement addToCart = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("bidBtn_btn")));
        addToCart.click();
    }
}

