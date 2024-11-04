package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {

	public WebDriver driver;

	public OffersPage(WebDriver driver) {
		this.driver = driver;
	}

	private By search = By.xpath("//input[@type='search']");
	private By productName = By.cssSelector("tr td:nth-child(1)");

	public void searchItem(String name) {

		driver.findElement(search).sendKeys(name);
		System.out.println("Git Test 1");
		System.out.println("Git Test 2");
		System.out.println("Git Test 3");
	}
	
	public void getSearchText()
	{
		driver.findElement(search).getText();
	}
	
	public String getProductName()
	{
		return driver.findElement(productName).getText();
	}

}