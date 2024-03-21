package PageObject;

import org.openqa.selenium.WebDriver;
// factory design pattern
public class PageObjectManager {
	 public Landingpage landingpage;
	 public Offerpage offerpage;
	 public CheckoutPage checkoutpage;
	 public WebDriver driver;
	public PageObjectManager(WebDriver driver)
	{
		this.driver=driver;
	}
	public Landingpage getlandingpage()
	{
		landingpage=new Landingpage(driver);
		return landingpage;
	}
	public Offerpage getofferpage()
	{
		offerpage=new Offerpage(driver);
		return offerpage;
	}
	public CheckoutPage getcheckoutpage()
	{
		checkoutpage=new CheckoutPage(driver);
		return checkoutpage;
	}
}
