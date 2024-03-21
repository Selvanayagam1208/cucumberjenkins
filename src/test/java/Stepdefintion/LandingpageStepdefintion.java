package Stepdefintion;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import PageObject.Landingpage;
//import PageObject.PageObjectManage;
import PageObject.PageObjectManager;
import Utils.DeepInjection;
import Utils.Testbase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LandingpageStepdefintion extends Testbase{
	
	WebDriverWait wb;
	String offerpageproductname;
	String landingpagename;
	public DeepInjection di;
	public Landingpage landingpage;
	PageObjectManager page;
	public LandingpageStepdefintion(DeepInjection di)
	{
		this.di=di;
		this.landingpage=di.pageobjectmanager.getlandingpage();
	}

	@Given("User is on greencart landing page")
	public void user_is_on_greencart_landing_page() {
		di.testbase.webdrivermanager();
		di.genericutils.maximize();
		System.out.println(landingpage.gettitleonpage());
		System.out.println(landingpage.geturl());
		Assert.assertTrue(landingpage.gettitleonpage().contains("GreenKart"));
		Assert.assertEquals(landingpage.geturl(),pro.getProperty("QAurl"));
	
			}
	@When("^User searched with shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortname) throws InterruptedException {
		landingpage.searchitem(shortname);
		Thread.sleep(2000);
		di.landingpagename = landingpage.getproductname().split("-")[0].trim();
		System.out.println(di.landingpagename+"--is the extracted landing page product name");
	}
	@When("add {string} items of selectes product to cart")
	public void add_items_of_selectes_product_to_cart(String increment) {
		landingpage.increment(Integer.parseInt(increment));
		landingpage.selectADDtoCart();
		landingpage.selectcart();
		landingpage.proceedcart();		    
	}

	
	
}
