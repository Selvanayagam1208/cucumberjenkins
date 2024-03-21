package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Testbase {
	public WebDriver driver;
	public static File f; 
	public static FileInputStream fis;
	public static Properties pro;
	public Testbase()
	{
	 f=new File(System.getProperty("user.dir")+"//src//test//Resources//global.properties");
	try {
		 fis=new FileInputStream(f);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 pro=new Properties();
	try {
		pro.load(fis);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public WebDriver webdrivermanager()
	{
		if(driver==null)
		{
			String browser_properties=pro.getProperty("browser"); // check the browser in global.properties
			String browser_maven=System.getProperty("browser"); // check the browser in command prompt 
			// java ternary operator
			// result=testcondition?value1:value2
			String browser=browser_maven!=null? browser_maven:browser_properties;
			
			if(browser.equalsIgnoreCase("chrome"))
			{
				driver=new ChromeDriver(); //driver gets the life		
			}
			if(browser.equalsIgnoreCase("edge"))
			{
				driver=new EdgeDriver(); //driver gets the life		
			}
			if(browser.equalsIgnoreCase("firebox"))
			{
			
				driver=new FirefoxDriver(); //driver gets the life		
			}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get(pro.getProperty("QAurl"));
		

		}
		return driver;

	}
}
