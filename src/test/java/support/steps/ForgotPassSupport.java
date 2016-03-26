package support.steps;

import org.junit.Assert;
import org.openqa.selenium.By;

import support.datas.Constant;
import support.utils.ReadProperties;

public class ForgotPassSupport extends CuchineSupport {

	public void CustomsFunction() {
		// code java implement CustomsFunction
	}

	public void openCuChinePage(String url) {
		driver.manage().deleteAllCookies();
		driver.navigate().to(url);
	}

	public void openSigin() {
		driver.findElement(By.xpath((ReadProperties.get(Constant.E_SIGNIN))))
				.click();
	}

	public void openFPW() {
		driver.findElement(
				By.xpath((ReadProperties.get(Constant.FORGOTPASSSEC)))).click();
	}

	public void fillEmail(String e) {
		driver.findElement(By.xpath((ReadProperties.get(Constant.FILMAIL))))
				.sendKeys(e);
	}

	public void checkGmail1(String url, String Email, String PW, String E) {
		driver.navigate().to(url);
		driver.findElement(By.xpath((ReadProperties.get(Constant.SIGINMAIL))))
				.click();
		driver.findElement(By.xpath((ReadProperties.get(Constant.GMFIELD))))
				.sendKeys(Email);
		driver.findElement(By.xpath((ReadProperties.get(Constant.GNEXTBTN))))
				.click();
	}

	public void checkGmail2(String url, String Email, String PW, String E) {
		driver.findElement(By.xpath((ReadProperties.get(Constant.GPW))))
				.clear();
		driver.findElement(By.xpath((ReadProperties.get(Constant.GPW))))
				.sendKeys(PW);
		driver.findElement(By.xpath((ReadProperties.get(Constant.GSN))))
				.click();
	}

	public void checkGmail3(String EmailTitle) {
		/*
		 * driver.findElement(By.xpath((ReadProperties.get(Constant.MAILB))))
		 * .click();
		 */
		Assert.assertEquals(EmailTitle, (driver.findElement(By
				.xpath(ReadProperties.get(Constant.MAILT))).getText()));
	}

	public void clickResetPw() {
		driver.findElement(By.xpath((ReadProperties.get(Constant.RESPW))))
				.click();
	}

	public void inputUsrPw(String usr, String pw) {

		driver.findElement(By.xpath(ReadProperties.get(Constant.E_MAILSIGNIN)))
				.clear();

		driver.findElement(By.xpath(ReadProperties.get(Constant.E_MAILSIGNIN)))
				.sendKeys(usr);

		driver.findElement(By.xpath(ReadProperties.get(Constant.E_MAILPW)))
				.clear();

		driver.findElement(By.xpath(ReadProperties.get(Constant.E_MAILPW)))
				.sendKeys(pw);

	}

	public void clickSI() {
		driver.findElement(By.xpath(ReadProperties.get(Constant.E_SIB)))
				.click();
	}

	public void receiveErr(String ErrContent) {		
		Assert.assertEquals(ErrContent,
				(driver.findElement(By.xpath(ReadProperties
						.get(Constant.ERREMAILCONTENT))).getText()));

	}

	public void clickGOTIT() {
		driver.findElement(By.xpath(ReadProperties.get(Constant.E_GOTITUP)))
				.click();
	}

	public void clickMyAcc() {
		driver.findElement(By.xpath(ReadProperties.get(Constant.MYACC)))
				.click();
	}

	public void clickMyAccInner() {
		driver.findElement(By.xpath(ReadProperties.get(Constant.MYACCIN)))
				.click();
	}

	public void clickChangePW() {
		driver.findElement(By.xpath(ReadProperties.get(Constant.CHANGEPW)))
				.click();
	}

	public void inputPW(String Old) {
		driver.findElement(By.xpath(ReadProperties.get(Constant.OLDPW)))
				.sendKeys(Old);
	}

	public void inputNewPW(String New, String Confir) {
		driver.findElement(By.xpath(ReadProperties.get(Constant.NEWPW)))
				.sendKeys(New);
		driver.findElement(By.xpath(ReadProperties.get(Constant.CONFIRPW)))
				.sendKeys(Confir);
	}

	public void submitTheChange() {
		driver.findElement(By.xpath(ReadProperties.get(Constant.UPDATEPWBTN)))
				.click();

	}

	public void saveChange() {
		driver.findElement(By.xpath(ReadProperties.get(Constant.SAVECHANGEBTN)))
				.click();
	}

	public void receiveThakPU(String ThankYouContent) {
		/*Assert.assertEquals(ThankYouTitle, (driver.findElement(By
				.xpath(ReadProperties.get(Constant.THAKTITLE))).getText()));*/
		Assert.assertEquals(ThankYouContent, (driver.findElement(By
				.xpath(ReadProperties.get(Constant.CHANGEPWCONT))).getText()));

	}

}
