package stepDefinitions;

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
import utils.TestContextSetup;

public class LandingPageStepDefinition {
	
	public WebDriver driver;
	
	public String landingPageProductName;
	public String offerPageProductName;
	TestContextSetup testConSet;
	LandingPage landingPage;
	
	public LandingPageStepDefinition(TestContextSetup testConSet)
	{
		this.testConSet = testConSet;
		this.landingPage = testConSet.pageObjectManager.getLandingPage();
		
	}
	
	@Given("User is on GreenKart landing page")
	public void user_is_on_green_kart_landing_page() {
		
//	    System.setProperty("webdriver.chrome.driver", "C:/Eknath/Selenium/Drivers/chromedriver.exe");
//	    testConSet.driver = new ChromeDriver();
//	    testConSet.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
	    
	}
	@When("^User searched with shortname (.+) and extracted actual name of the product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_the_product(String shortName) throws InterruptedException {
		
		//LandingPage landingPage = new LandingPage(testConSet.driver);
		
		landingPage.searchItem(shortName);
		//testConSet.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		
		Thread.sleep(2000);
		//String landingPageProductName = testConSet.driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
		//testConSet.landingPageProductName = testConSet.driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
		testConSet.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
		System.out.println(testConSet.landingPageProductName+" is extracted from home page");
	    
	}
	
	@When("Added {string} items of the selected product to cart")
	public void Added_items_of_the_selected_product_to_cart(String quantity)
	{
		
		landingPage.incrementQuantity(Integer.parseInt(quantity));
		landingPage.addToCart();
	}

}