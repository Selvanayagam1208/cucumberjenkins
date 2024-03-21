package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Landingpage {
	public WebDriver driver;
	
	public Landingpage(WebDriver driver)
	{
		this.driver=driver;
	}
	private By search=By.xpath("//input[@type='search']");
	private By productname=By.cssSelector("h4.product-name");
	private By deal=By.partialLinkText("Top");
	private By increment=By.cssSelector("a.increment");
	private By Addtocart=By.xpath("//button[text()='ADD TO CART']");
	private By checkoutbutton=By.cssSelector("a.cart-icon");
	private By proceed=By.xpath("//button[text()='PROCEED TO CHECKOUT']");


	public void searchitem(String name)
	{
		driver.findElement(search).sendKeys(name);
	}
	public void getsearchtext()
	{
		driver.findElement(search).getText();
	}
	public String getproductname()
	{
		return driver.findElement(productname).getText();
	}
	public void selectTopdeal()
	{
		driver.findElement(deal).click();
	}
	public void increment(int times)
	{
		for(int i=0;i<times;i++)
		{
		driver.findElement(increment).click();
		}
	}
	public void selectADDtoCart()
	{
		driver.findElement(Addtocart).click();
	}
	public String gettitleonpage()
	{
		return driver.getTitle();
	}
	public String geturl()
	{
		return driver.getCurrentUrl();
	}
	public void  selectcart()
	{
		driver.findElement(checkoutbutton).click();
	}
	public void proceedcart()
	{
		driver.findElement(proceed).click();
	}
}
