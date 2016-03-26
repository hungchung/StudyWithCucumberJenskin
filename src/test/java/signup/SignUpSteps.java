package signup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import support.steps.SignUpSupport;

public class SignUpSteps {

	private SignUpSupport support;

	public SignUpSteps() {
		support = new SignUpSupport();
	}
	@Given("^I am a new customer who wants to sign-up as a member of site and I access the website via the URL \"([^\"]*)\"$")
	public void i_am_a_new_customer_who_wants_to_sign_up_as_a_member_of_site_and_I_access_the_website_via_the_URL(
			String url) throws Throwable {
		support.openCuChinePage(url);
	}

	@When("^I click on the Sign Up in header$")
	public void i_click_on_the_Sign_Up_in_header() throws Throwable {
		support.openSigup();
	}

	@When("^Click on X label$")
	public void click_on_X_label() throws Throwable {
		support.closePopUp();
	}

	@Then("^I can see the pop-up will be closed properly$")
	public void i_can_see_the_pop_up_will_be_closed_properly() throws Throwable {
		support.checkClosePU();
	}

	@When("^Click on Sign Up With Facebook button$")
	public void click_on_Sign_Up_With_Facebook_button() throws Throwable {
		support.clickFBbtn();
	}

	@When("^Log in with facebook account \"([^\"]*)\", \"([^\"]*)\"$")
	public void log_in_with_facebook_account(String usr, String pw)
			throws Throwable {
		Thread.sleep(5000);
		support.logInonFBPU(usr, pw);
	}

	@When("^fill \"([^\"]*)\" and click on Sign Up with your email$")
	public void fill_and_click_on_Sign_Up_with_your_email(String EFB)
			throws Throwable {
		support.signInFBEmail(EFB);
	}

	@When("^fill user-info into the form on the Sign up pop-up as \"([^\"]*)\" \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"  into the form as$")
	public void fill_user_info_into_the_form_on_the_Sign_up_pop_up_as_into_the_form_as(
			String FN, String LN, String PN, String ZC, String PW, String PWC)
			throws InterruptedException {
		Thread.sleep(2000);
		support.fillUserInfo(FN, LN, PN, ZC, PW, PWC);
	}


	
}
