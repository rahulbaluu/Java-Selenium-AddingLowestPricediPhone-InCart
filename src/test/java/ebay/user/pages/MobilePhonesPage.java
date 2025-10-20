package ebay.user.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MobilePhonesPage extends BasePage {
	public MobilePhonesPage(WebDriver driver) {
		super(driver);
	}

	public void filterByLowToHigh() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement dropdownBtn = wait.until(ExpectedConditions.elementToBeClickable(
				By.cssSelector("button.fake-menu-button__button[aria-label^='Sort selector']")));
		dropdownBtn.click();

		wait.until(ExpectedConditions.attributeToBe(dropdownBtn, "aria-expanded", "true"));

		WebElement lowToHighOption = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//a[contains(@class, 'fake-menu-button__item') and contains(., 'Price + Shipping: lowest first')]")));
		lowToHighOption.click();
	}

	public void addLowestPricedPhoneToCart() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for all product cards to load
		List<WebElement> phoneCards = wait.until(
				ExpectedConditions.presenceOfAllElementsLocatedBy(
						By.cssSelector("li.s-card")));

		// Log for debugging
		System.out.println("Phones found: " + phoneCards.size());
		System.out.println(phoneCards.get(2).getText());
		phoneCards.get(2).click();
	}
}
