package landingpage;

import support.steps.LandingPageSupport;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LandingPageSteps {

	private LandingPageSupport support;

	public LandingPageSteps() {
		support = new LandingPageSupport();
	}

	@Given("^as customer who want to pick up a dish so access to the website via URL \"([^\"]*)\"$")
	public void as_customer_who_want_to_pick_up_a_dish_so_access_to_the_website_via_URL(
			String url) throws Throwable {
		support.openCuChinePage(url);
	}

	@When("^I input Zipcode as \"([^\"]*)\"$")
	public void i_input_Zipcode_as(String zipCode) throws Throwable {
		support.zipcodeInput(zipCode);
	}

	@When("^I submit the Zip code by clicking on \\[See What Cooking\\] button$")
	public void i_submit_the_Zip_code_by_clicking_on_See_What_Cooking_button()
			throws InterruptedException {
		Thread.sleep(8000);
		support.zipcodeSubmit();

	}

	@Then("^I will check that the Zip Code zone being displayed in the first time, display Menu page will be shown \"([^\"]*)\"$")
	public void i_will_check_that_the_Zip_Code_zone_being_displayed_in_the_first_time_display_Menu_page_will_be_shown(
			String dailyURL) throws Throwable {
		support.zipcodeRedirectDailyMenu(dailyURL);
	}

	@When("^I input \"([^\"]*)\" into email field$")
	public void i_input_into_email_field(String email) throws InterruptedException {
		Thread.sleep(3000);
		support.zipcodeEmail(email);
	}

	@When("^I click \\[Keep Me in the Loop\\] button$")
	public void i_click_Keep_Me_in_the_Loop_button() throws Throwable {
		support.zipcodeSubmitLoopBtn();
	}

	@Then("^I can redirect to register page \"([^\"]*)\"$")
	public void i_can_redirect_to_register_page(String regiURL) throws Throwable {
		support.zipcodeRedirectRP(regiURL);	
	}

	@Then("^I can refirect to Daily menu page \"([^\"]*)\"$")
	public void i_can_refirect_to_Daily_menu_page(String dailyURL)
			throws Throwable {
		support.zipcodeRedirectDailyMenu(dailyURL);
	}

	@Then("^System displays error message \"([^\"]*)\"$")
	public void system_displays_error_message(String errorMs)
			throws Throwable {
		support.zipcodeErrorMsg(errorMs);

	}

	@Then("^I can refirect to Daily menu page \"([^\"]*)\" with pickup only$")
	public void i_can_refirect_to_Daily_menu_page_with_pickup_only(
			String dailyURL) throws Throwable {
		support.zipcodeRedirectDailyMenuWithPK(dailyURL);
	}

	@When("^I click on Logo$")
	public void i_click_on_Logo() throws Throwable {
		support.ladingClickLogo();
	}

	@Then("^I will be visited to landing page \"([^\"]*)\"$")
	public void i_will_be_visited_to_lading_page(String landingURL)
			throws Throwable {
		support.landingDisplayedCorrectURL(landingURL);

	}

	@When("^I click on Our Philosophy$")
	public void i_click_on_Our_Philosophy() throws Throwable {
		support.landingOurPhilClick();
	}

	@Then("^I will be visited to Our Philosophy page \"([^\"]*)\"$")
	public void i_will_be_visited_to_Our_Philosophy_page(String op)
			throws Throwable {
		support.landingDisplayedCorrectURL(op);
	}

	@When("^I click on How It Work$")
	public void i_click_on_How_It_Work() throws Throwable {
		support.landingHowItClick();
	}

	@Then("^I will be visited to How It Work page \"([^\"]*)\"$")
	public void i_will_be_visited_to_How_It_Work_page(String htw)
			throws Throwable {
		support.landingDisplayedCorrectURL(htw);
	}

	@When("^I click on Cook With Us$")
	public void i_click_on_Cook_With_Us() throws Throwable {
		support.landingCookWithClick();

	}

	@Then("^I will be visited to Cook With Us page \"([^\"]*)\"$")
	public void i_will_be_visited_to_Cook_With_Us_page(String cwu)
			throws Throwable {
		support.landingDisplayedCorrectURL(cwu);

	}

}
