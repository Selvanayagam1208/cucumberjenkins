package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	WebDriver driver;
	public CheckoutPage checkoutpage;

	public CheckoutPage(WebDriver driver)
	{
		this.driver=driver;
	
	}
//	private By checkoutbutton=By.cssSelector("a.cart-icon");
//	private By proceed=By.xpath("//button[text()='PROCEED TO CHECKOUT']");
	private By productname=By.cssSelector("h4.product-name");
	private By promobtn=By.xpath("//button[text()='Apply']");
	private By placeorder=By.xpath("//button[text()='Place Order']");

	
	public String getcheckoutproductname()
	{
		return driver.findElement(productname).getText();
	}
	public boolean checkpromobtn()
	{
		return driver.findElement(promobtn).isDisplayed();
	}
	public boolean checkplaceorder()
	{
		return driver.findElement(placeorder).isDisplayed();
	}
}
