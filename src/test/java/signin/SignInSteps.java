package signin;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import support.steps.SignInSupport;

public class SignInSteps {

	private SignInSupport support;

	public SignInSteps() {
		support = new SignInSupport();
	}

	@Given("^I am a customer who wants to sign-in and access the website via the URL \"([^\"]*)\"$")
	public void i_am_a_customer_who_wants_to_sign_in_and_access_the_website_via_the_URL(
			String URL) throws InterruptedException {
		Thread.sleep(2000);
		support.openCuChinePage(URL);
	}

	@When("^I click on the Sign in section at the header$")
	public void i_click_on_the_Sign_in_section_at_the_header()
			throws InterruptedException {
		Thread.sleep(10000);
		support.openSigin();
	}

	@When("^Click on X label$")
	public void click_on_X_label() throws InterruptedException {
		Thread.sleep(3000);
		support.closePopUp();
	}

	@Then("^I can see the pop-up will be closed properly$")
	public void i_can_see_the_pop_up_will_be_closed_properly() throws Throwable {
		support.checkClosePU();
	}

	@When("^fill Email and Password into the form with \"([^\"]*)\" , \"([^\"]*)\"$")
	public void i_fills_my_Email_and_Password_into_the_form_with(String usr,
			String pw) throws Throwable {
		support.inputUsrPw(usr, pw);
	}

	@When("^click on Sign In button$")
	public void i_click_on_Sign_In_button() throws Throwable {
		support.clickSI();
	}

	@Then("^I will be redirected to Daily Menu page with \"([^\"]*)\"$")
	public void i_will_be_redirected_to_Daily_Menu_page_with(String URL)
			throws Throwable {
		support.checkSignSuccessful(URL);
	}

	@When("^check on the Keep me Sign in checkbox$")
	public void i_check_on_the_Keep_me_Sign_in_checkbox() throws Throwable {
		support.checkKeepSI();
	}

	/*
	 * @When("^close the browser and open again \"([^\"]*)\"$") public void
	 * i_close_the_browser_and_open_again(String URL) throws
	 * InterruptedException { support.reOpenbrowser(URL); Thread.sleep(3000); }
	 */

	@When("^click on Sign in with Facebook$")
	public void click_on_Sign_in_with_Facebook() throws InterruptedException {
		Thread.sleep(3000);
		support.clickSIFB();
	}

	@When("^sign in with \"([^\"]*)\" , \"([^\"]*)\"$")
	public void sign_in_with(String Email, String Pw)
			throws InterruptedException {
		Thread.sleep(5000);
		support.signInFB(Email, Pw);
	}

	@Then("^I will receice a validation message from system \"([^\"]*)\"$")
	public void i_will_receice_a_validation_message_from_system(
			String Err) throws InterruptedException {
		Thread.sleep(5000);
		support.checkValidation(Err);
	}

	@Then("^I will be redirected to Daily Menu page with validation message \"([^\"]*)\"$")
	public void i_will_be_redirected_to_Daily_Menu_page_with_validation_message(String Errmes) throws InterruptedException {
		Thread.sleep(5000);
		support.checkValidationWithFB(Errmes);
	}

	@Then("^I will be redirected to Daily Menu page with account info \"([^\"]*)\"$")
	public void i_will_be_redirected_to_Daily_Menu_page_with_account_info(
			String URL) throws InterruptedException {
		Thread.sleep(2000);
		support.checkRedirectionAccountInfo(URL);
	}

}
