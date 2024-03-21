package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Offerpage {
	public WebDriver driver;
	public Offerpage(WebDriver driver)
	{
		this.driver=driver;
	}
	private By search1=By.id("search-field");
	private By productname1=By.xpath("//table[@class='table table-bordered']/tbody/tr/td[1]");
	
	public void searchitem(String name)
	{
		driver.findElement(search1).sendKeys(name);
	}
	public void gettext()
	{
		driver.findElement(search1).getText();
	}
	public String getproductname()
	{
		return driver.findElement(productname1).getText();
	}

}
