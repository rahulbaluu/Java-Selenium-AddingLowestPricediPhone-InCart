package ebay.user.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {
	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void openHomePage() {
		driver.get("https://www.ebay.com/");
	}

	public void hoverShopByCategory() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gdpr-banner-accept")));
		WebElement consent = driver.findElement(By.id("gdpr-banner-accept"));
		new Actions(driver).moveToElement(consent).build().perform();
		WebElement categoryMenu = driver.findElement(By.cssSelector("span.gh-categories__title"));
		new Actions(driver).moveToElement(categoryMenu).perform();
	}

	public void clickCategory(String linkText) {
		// Click the consent button
		WebElement consent = wait.until(ExpectedConditions.elementToBeClickable(By.id("gdpr-banner-accept")));
		consent.click();

		// Click the "Product search button" button
		WebElement shopByCategory = wait.until(ExpectedConditions.elementToBeClickable(
						By.id("gh-ac")));
		shopByCategory.sendKeys("iPhone");

		// Click the "Search button"
		WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("gh-search-btn")));
		searchButton.click();
	}

}

