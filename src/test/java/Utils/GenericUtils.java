package Utils;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
	public WebDriver driver;
	public GenericUtils(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void maximize()
	{
		driver.manage().window().maximize();

	}
	public void implictwait()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void switchTowindow()
	{
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> iterator = s1.iterator();
		String parentwindow=iterator.next();
		String childwindow = iterator.next();
		driver.switchTo().window(childwindow);
	}
}
