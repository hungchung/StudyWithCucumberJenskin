package checkout;

import java.util.List;

import support.steps.CheckoutSupport;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CheckoutSteps {

	private CheckoutSupport support;

	public CheckoutSteps() {
		support = new CheckoutSupport();
	}

	@Given("^Customer access to the checkout page from daily-menu and he wants to payment for the dishes on cart \"([^\"]*)\" \"([^\"]*)\"$")
	public void customer_access_to_the_checkout_page_from_daily_menu_and_he_wants_to_payment_for_the_dishes_on_cart(
			String url, String data, List<List<String>> tb) throws Throwable {
		support.openCuChinePage(url);
		support.getdataTb(tb);
	}

	@When("^I access to Dailymenu page with \"([^\"]*)\"$")
	public void i_access_to_Dailymenu_page_with(String zipcode)
			throws Throwable {
		support.zipcodeInput(zipcode);
		support.zipcodeSubmit();
	}

	@When("^click Got it button$")
	public void click_Got_it_button() throws InterruptedException {
		Thread.sleep(5000);
		support.clickGOTIT();
	}

	/*@When("^open sign in section$")
	public void open_sign_in_section() throws Throwable {
		support.openSigin();
	}

	@When("^sign in with an account \"([^\"]*)\" \"([^\"]*)\"$")
	public void sign_in_with_an_account(String usr, String pw) throws InterruptedException {
		Thread.sleep(1000);
		support.inputUsrPw(usr, pw);
		support.clickSI();
	}*/

	@When("^open detail a dish \"([^\"]*)\"$")
	public void open_detail_a_dish(String Dishname) throws InterruptedException {
		Thread.sleep(3000);
		support.openADish(Dishname);
	}

	@When("^select quantity of dish \"([^\"]*)\"$")
	public void select_quantity_of_dish(String Quantity)
			throws Throwable {
		/*
		 * Thread.sleep(5000); support.selectQuantityOfDish1();
		 * Thread.sleep(500); support.selectQuantityOfDish2(Quantity);
		 */
	}

	@When("^select quantity of Garlic Rice \"([^\"]*)\"$")
	public void select_quantity_of_Garlic_Rice(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^select quantiy of Mashed Potato \"([^\"]*)\"$")
	public void select_quantiy_of_Mashed_Potato(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^select Pick Up Time \"([^\"]*)\"$")
	public void select_Pick_Up_Time(String PT) throws Throwable {
		support.selectPickUpTime(PT);
	}

	@When("^select Delivery Time \"([^\"]*)\"$")
	public void select_Delivery_Time(String DT) throws Throwable {
		support.selectDeliveryTime(DT);
	}

	@When("^select Packaging \"([^\"]*)\"$")
	public void select_Packaging(String pac) throws Throwable {
		support.selectPackage(pac);
	}

	@When("^add a note for the Chef$")
	public void add_a_note_for_the_Chef() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^click on Checkout button$")
	public void click_on_Checkout_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^select Payment option and Delivery Address$")
	public void select_Payment_option_and_Delivery_Address() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^click on Place Order button in checkout page \"([^\"]*)\"$")
	public void click_on_Place_Order_button_in_checkout_page(String arg1)
			throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^Checkout process is completed and redirected to Thankyou page \"([^\"]*)\"$")
	public void checkout_process_is_completed_and_redirected_to_Thankyou_page(
			String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^edit quantity of Main Dishes$")
	public void edit_quantity_of_Main_Dishes() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^remove some dishes$")
	public void remove_some_dishes() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^click on Place Order button in checkout page$")
	public void click_on_Place_Order_button_in_checkout_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^Checkout process is completed, verify info and redirected to Thankyou page \"([^\"]*)\"$")
	public void checkout_process_is_completed_verify_info_and_redirected_to_Thankyou_page(
			String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^remove current dish$")
	public void remove_current_dish() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^Checkout process is not completed with error pop-up \"([^\"]*)\" \"([^\"]*)\"$")
	public void checkout_process_is_not_completed_with_error_pop_up(
			String arg1, String arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^Press Checkout button$")
	public void press_Checkout_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^Press Back to Dailymenu$")
	public void press_Back_to_Dailymenu() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^Press Back to Menu section \"([^\"]*)\"$")
	public void press_Back_to_Menu_section(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^I will be back to Dailymenu page \"([^\"]*)\"$")
	public void i_will_be_back_to_Dailymenu_page(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}
}
