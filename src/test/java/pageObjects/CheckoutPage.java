package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

	public WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	By cartBag = By.xpath("//img[@alt=\"Cart\"]");
	By checkOutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	By promoBtn = By.xpath("//button[@class='promoBtn']");
	By placeOrderBtn = By.xpath("//button[contains(text(),'Place Order')]");
	
	
	public void CheckoutItems()
	{
		driver.findElement(cartBag).click();
		driver.findElement(checkOutButton).click();
		System.out.println("Git Test 1 in develop branch");
	}
	
	public boolean VerifyPromoBtn()
	{
		return driver.findElement(promoBtn).isDisplayed();
	}
	
	public boolean VerifyPlaceOrderBtn()
	{
		return driver.findElement(placeOrderBtn).isDisplayed();
	}



}