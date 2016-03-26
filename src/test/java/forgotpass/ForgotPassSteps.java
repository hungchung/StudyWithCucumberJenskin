package forgotpass;

import org.openqa.selenium.By;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import support.datas.Constant;
import support.steps.ForgotPassSupport;
import support.utils.ReadProperties;

public class ForgotPassSteps {

	private ForgotPassSupport support;

	public ForgotPassSteps() {
		support = new ForgotPassSupport();
	}

	@Given("^I am a customer who wants to get back the password from the website via the URL \"([^\"]*)\"$")
	public void i_am_a_customer_who_wants_to_get_back_the_password_from_the_website_via_the_URL(String URL) throws InterruptedException {		
		support.openCuChinePage(URL);
		Thread.sleep(3000);
	}

	@When("^Customer click on the section Sign in at the header$")
	public void customer_click_on_the_section_Sign_in_at_the_header()
			throws Throwable {
		Thread.sleep(5000);
		support.openSigin();

	}

	@When("^click on Forgot Password section$")
	public void click_on_Forgot_Password_section() throws Throwable {
		support.openFPW();
	}

	@When("^fills my \"([^\"]*)\" into the field$")
	public void fills_my_into_the_field(String email) throws Throwable {
		support.fillEmail(email);
		Thread.sleep(2000);
	}

	@When("^click on Reset Password button$")
	public void click_on_Reset_Password_button() throws Throwable {
		support.clickResetPw();
		Thread.sleep(2000);
	}

	@When("^open the mailbox to check the new password \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void open_the_mailbox_to_check_the_new_password(String EmailTitle,
			String PW, String Email, String url) throws InterruptedException {
		support.checkGmail1(url, Email, PW, EmailTitle);
		Thread.sleep(2000);
		support.checkGmail2(url, Email, PW, EmailTitle);

	}

	@Then("^Customer receive a email with new password \"([^\"]*)\"$")
	public void customer_receive_a_email_with_new_password(String EmailTitle)
			throws InterruptedException {
		Thread.sleep(5000);
		support.checkGmail3(EmailTitle);
	}

	@Then("^Customer recieve an pop-up with error message \"([^\"]*)\"$")
	public void customer_recieve_an_pop_up_with_error_message(String ErrContent) throws InterruptedException {
		Thread.sleep(2000);
		support.receiveErr(ErrContent);
	}

	@When("^Sign-in by account \"([^\"]*)\" \"([^\"]*)\"$")
	public void sign_in_by_account(String usr, String pw)
			throws InterruptedException {
		Thread.sleep(1000);
		support.inputUsrPw(usr, pw);
		support.clickSI();
	}

	@When("^click on My Account$")
	public void click_on_My_Account() throws InterruptedException {
		Thread.sleep(8000);
		support.clickGOTIT();
		Thread.sleep(2000);
		support.clickMyAcc();
		Thread.sleep(2000);
		support.clickMyAccInner();
	}

	@When("^click on field of Change Password$")
	public void click_on_field_of_Change_Password() throws InterruptedException {
		Thread.sleep(2000);
		support.clickChangePW();
	}

	@When("^input old password \"([^\"]*)\"$")
	public void input_old_password(String Old) throws Throwable {
		support.inputPW(Old);
	}

	@When("^input New password and confirm password \"([^\"]*)\" \"([^\"]*)\"$")
	public void input_New_password_and_confirm_password(String New,
			String Confir) throws Throwable {
		support.inputNewPW(New, Confir);
	}

	@When("^submit the change$")
	public void submit_the_change() throws InterruptedException {
		support.submitTheChange();
		Thread.sleep(3000);
	}

	@Then("^Customer can change password and receive a thank you pop-up \"([^\"]*)\"$")
	public void customer_can_change_password_and_receive_a_thank_you_pop_up(String ThankYouContent) throws Throwable {
		support.receiveThakPU(ThankYouContent);
	}

}
