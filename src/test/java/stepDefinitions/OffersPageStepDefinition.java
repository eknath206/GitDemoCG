package stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OffersPageStepDefinition {

	public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	TestContextSetup testConSet;
	PageObjectManager pageObjectManager;

	public OffersPageStepDefinition(TestContextSetup testConSet) {
		this.testConSet = testConSet;
	}
	
	@Then("^User searched for (.+) shortname in offers page$")
	public void user_searched_for_shortname_in_offers_page(String shortName) throws InterruptedException {
		
		switchToOffersPage();
		
		//OffersPage offersPage = new OffersPage(testConSet.driver);
		//testConSet.driver.findElement(By.id("search-field")).sendKeys(shortName);
		OffersPage offersPage = testConSet.pageObjectManager.getOffersPage();
		offersPage.searchItem(shortName);
		//testConSet.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		Thread.sleep(2000);
		//String offerPageProductName = testConSet.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
		offerPageProductName = offersPage.getProductName();
		
		System.out.println(offerPageProductName + " is extracted from Offers Page.");
		System.out.println(testConSet.landingPageProductName + " is extracted from Landing page");
	}

	public void switchToOffersPage() {

		//pageObjectManager = new PageObjectManager(testConSet.driver);
		//testConSet.driver.findElement(By.linkText("Top Deals")).click();
		//LandingPage landingPage = new LandingPage(testConSet.driver);
		//LandingPage landingPage = pageObjectManager.getLandingPage();
		LandingPage landingPage = testConSet.pageObjectManager.getLandingPage();
		landingPage.selectTopDealsPage();
//		Set<String> s1 = testConSet.driver.getWindowHandles();
//		Iterator<String> i1 = s1.iterator();
//		String parentWindow = i1.next();
//		String childWindow = i1.next();
//		testConSet.driver.switchTo().window(childWindow);
		testConSet.genericUtils.SwitchWindowToChild();

	}

	@Then("validate product name in Offers page matches with Landing page")
	public void validate_product_name_in_Offers_page() {

		Assert.assertEquals(offerPageProductName, testConSet.landingPageProductName);

	}

}