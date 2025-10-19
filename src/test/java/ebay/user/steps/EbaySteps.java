package ebay.user.steps;

import ebay.user.pages.*;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EbaySteps {
	WebDriver driver;
	HomePage homePage;
	MobilePhonesPage mobilePage;
	ProductPage productPage;

	@Given("I open the eBay homepage")
	public void i_open_the_e_bay_homepage() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/rahulbalashanmugam/Downloads/chromedriver-mac-arm64/chromedriver");
		driver = new ChromeDriver();
		homePage = new HomePage(driver);
		mobilePage = new MobilePhonesPage(driver);
		productPage = new ProductPage(driver);

		homePage.openHomePage();
		homePage.takeScreenshot("01_homepage");
	}

	@When("I hover over {string}")
	public void i_hover_over(String category) throws Exception {
		homePage.hoverShopByCategory();
		homePage.takeScreenshot("02_hover_category");
	}

	@And("I click on {string}")
	public void i_click_on(String linkText) throws Exception {
		homePage.clickCategory(linkText);
		homePage.takeScreenshot("03_click_" + linkText.replace(" ", "_"));
	}

	@And("I click dropdown by {string}")
	public void i_click_dropdown_by(String LowtoHigh) throws Exception {
		mobilePage.filterByLowToHigh();
		mobilePage.takeScreenshot("04_filter_" + LowtoHigh.replace(" ", "_"));
	}

	@And("I click on the first Apple mobile phone listed")
	public void i_click_on_the_first_apple_mobile_phone_listed() throws Exception {
		mobilePage.addLowestPricedPhoneToCart();
		mobilePage.takeScreenshot("05_product_page");
	}

	@And("I add the product to the cart")
	public void i_add_the_product_to_the_cart() throws Exception {
		productPage.addToCart();
		productPage.takeScreenshot("06_added_to_cart");
	}

	@Then("I take a screenshot after each step")
	public void i_take_a_screenshot_after_each_step() {
		System.out.println("Screenshots captured.");
		driver.quit();
	}
}
