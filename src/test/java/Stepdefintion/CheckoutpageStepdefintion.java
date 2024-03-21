package Stepdefintion;

import org.testng.Assert;

import PageObject.CheckoutPage;
import Utils.DeepInjection;
import io.cucumber.java.en.Then;

public class CheckoutpageStepdefintion {
	public DeepInjection di;
	String checkoutpagename;
	public CheckoutPage checkoutpage;
	

	public CheckoutpageStepdefintion(DeepInjection di)
	{
		this.di=di;
		this.checkoutpage=di.pageobjectmanager.getcheckoutpage();
	}
		@Then("^user proceed to checkout and validate the (.+) item in checkout page$")
	public void user_proceed_to_checkout_and_validate_the_item_in_checkout_page(String shortname) {
		checkoutpagename=checkoutpage.getcheckoutproductname().split("a")[0].trim();
		System.out.println(checkoutpagename+"-- is the extracted checkoutpage name");
		Assert.assertEquals(checkoutpagename, shortname);
	    	}
	@Then("verify user has ablity to enter promocode and place the order")
	public void verify_user_has_ablity_to_enter_promocode_and_place_the_order() {
		Assert.assertTrue(checkoutpage.checkpromobtn());
		Assert.assertTrue(checkoutpage.checkplaceorder());
	}


}
