package Stepdefintion;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Utils.DeepInjection;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class Hooks {
	DeepInjection di;
	byte[] content;

	public Hooks(DeepInjection di)
	{
		this.di=di;
	}
	@After
	public void Afterscenario()
	{
		di.testbase.webdrivermanager().quit();
		
	}
	@AfterStep
	public void addscreenshots(Scenario scenario)
	{

		WebDriver driver=di.testbase.webdrivermanager();
		if(scenario.isFailed())
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
		
			try {
				content = FileUtils.readFileToByteArray(source);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			scenario.attach(content, "image/png", "image");
		}

	}
}
