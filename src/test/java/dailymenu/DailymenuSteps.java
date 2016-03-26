package dailymenu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import support.datas.Constant;
import support.steps.DailymenuSupport;
import support.utils.ReadProperties;
import support.steps.LandingPageSupport;

import java.util.List;
import java.util.Map;

public class DailymenuSteps {

	private DailymenuSupport support;
	
	public DailymenuSteps() {
		support = new DailymenuSupport();
	}
	
	@Given("^Customer access to the Daily-menu page and check around the dishes \"([^\"]*)\" \"([^\"]*)\"$")
	public void customer_access_to_the_Daily_menu_page_and_check_around_the_dishes(
			String url, String data, List<List<String>> tb) throws Throwable {
		support.openCuChinePage(url);
		support.getdataTb(tb);
	}

	@When("^I access to Dailymenu page with \"([^\"]*)\"$")
	public void i_access_to_Dailymenu_page_with(String zipcode)
			throws InterruptedException {
		support.zipcodeInput(zipcode);
		support.zipcodeSubmit();
	}

	@When("^click on Calendar$")
	public void click_on_Calendar() throws InterruptedException {
		Thread.sleep(8000);
		support.clickGotit();
		Thread.sleep(2000);
		support.clickonCurrentDate();
		Thread.sleep(1000);
		support.clickDate();
	}

	@Then("^I check Menu that related to user zip code \"([^\"]*)\" \"([^\"]*)\"$")
	public void i_check_Menu_that_related_to_user_zip_code(String date,String data) throws InterruptedException {
		support.comparedata(date, data, support.dataTb);
	}

	@When("^Select a day in calendar$")
	public void select_a_day_in_calendar() throws Throwable {
		
		throw new PendingException();
	}

	@Then("^I can see the dishes of that day$")
	public void i_can_see_the_dishes_of_that_day() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^Click on a dish$")
	public void click_on_a_dish() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^I can see detail of dish \"([^\"]*)\"$")
	public void i_can_see_detail_of_dish(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^Click on Chef$")
	public void click_on_Chef() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^I can see detail of Chef \"([^\"]*)\"$")
	public void i_can_see_detail_of_Chef(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

}
