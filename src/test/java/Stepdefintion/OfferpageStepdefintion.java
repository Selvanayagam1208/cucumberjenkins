package Stepdefintion;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import PageObject.Landingpage;
import PageObject.Offerpage;
//import PageObject.PageObjectManage;
import Utils.DeepInjection;
import Utils.Testbase;
import io.cucumber.java.en.Then;

public class OfferpageStepdefintion extends Testbase  {
	WebDriver driver;
	WebDriverWait wb;
	String offerpageproductname;
	String landingpagename;
	public DeepInjection di;
	Landingpage landingpage;
	Offerpage offerpage;
	

	public OfferpageStepdefintion(DeepInjection di)
	{
		this.di=di;
		this.landingpage=di.pageobjectmanager.getlandingpage();
		this.offerpage=di.pageobjectmanager.getofferpage();
	}
	// single responsibilty
	//loosely couple
	public void switchtooffer()
	{
		landingpage.selectTopdeal();
		di.genericutils.switchTowindow();
	}
	@Then("^User searched for same shortname (.+) in offerpage to check if product exist$")
	public void user_searched_for_same_shortname_in_offerpage_to_check_if_product_exist(String shortname) {
		switchtooffer();
		offerpage.searchitem(shortname);
		offerpageproductname=offerpage.getproductname().trim();
		System.out.println(offerpageproductname+"--is extracted productname in offerpage");
	}
	@Then("Validate productname in offer page matches with landing page")
	public void validate_productname_in_offer_page_matches_with_landing_page() {
		Assert.assertEquals(di.landingpagename, offerpageproductname);
	}

}
