package support.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;

import support.datas.Constant;
import support.utils.ReadProperties;

public class CheckoutSupport extends CuchineSupport {
	public List<List<String>> dataTb;

	public void openCuChinePage(String url) {
		driver.manage().deleteAllCookies();
		driver.navigate().to(url);
	}

	public void zipcodeInput(String zipCode) {
		driver.findElement(By.xpath(ReadProperties.get(Constant.E_ZIP_CODE)))
				.clear();
		driver.findElement(By.xpath(ReadProperties.get(Constant.E_ZIP_CODE)))
				.sendKeys(zipCode);
	}

	public void zipcodeSubmit() {
		driver.findElement(By.xpath(ReadProperties.get(Constant.E_SUBMIT_CODE)))
				.click();
	}

	public void zipcodeRedirectDailyMenu(String dailyURL)
			throws InterruptedException {
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, dailyURL);
		Thread.sleep(8000);
		driver.findElement(By.xpath(ReadProperties.get(Constant.E_GOTITUP)))
				.click();

		Assert.assertEquals("", (driver.findElement(By.xpath(ReadProperties
				.get(Constant.E_DAILYPK))).getAttribute("class")));

		Assert.assertEquals("", (driver.findElement(By.xpath(ReadProperties
				.get(Constant.E_DAILYDELI))).getAttribute("class")));

	}

	public void getdataTb(List<List<String>> dataTb) {
		this.dataTb = dataTb;
	}

	public void zipcodeEmail(String email) {
		driver.findElement(
				By.xpath(ReadProperties.get(Constant.E_ZIP_CODE_MAIL))).clear();
		driver.findElement(
				By.xpath(ReadProperties.get(Constant.E_ZIP_CODE_MAIL)))
				.sendKeys(email);
	}

	public void zipcodeSubmitLoopBtn() {
		driver.findElement(By.xpath(ReadProperties.get(Constant.E_LOOP_BTN)))
				.click();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}

	public void openSigin() {
		driver.findElement(By.xpath((ReadProperties.get(Constant.E_SIGNIN))))
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

	public void clickGOTIT() {
		driver.findElement(By.xpath(ReadProperties.get(Constant.E_GOTITUP)))
				.click();
	}

	public void zipcodeErrorMsg(String errorTl, String errorMs) {
		try {
			Assert.assertEquals(
					errorTl,
					driver.findElement(
							By.xpath(ReadProperties
									.get(Constant.E_ZIPCODEERRORMSG1)))
							.getText());
			Assert.assertEquals(
					errorMs,
					driver.findElement(
							By.xpath(ReadProperties
									.get(Constant.E_ZIPCODEERRORMSG2)))
							.getText());
		} catch (Exception e) {
			Assert.assertEquals(errorTl, "");
			Assert.assertEquals(errorMs, "");
		}
	}

	public void openADish(String Dishname) {
		driver.findElement(By.xpath(ReadProperties.get(Dishname))).click();
	}

	public void selectQuantityOfDish1() {
		driver.findElement(By.xpath(ReadProperties.get(Constant.QUANTY1)))
				.click();
	}

	public void selectQuantityOfDish2(String Quantity) {

		driver.findElement(By.xpath(ReadProperties.get(Quantity))).click();
	}

	public void selectDeliveryTime(String DT) {
		driver.findElement(By.xpath(ReadProperties.get(DT))).click();
	}

	public void selectPickUpTime(String PT) {
		driver.findElement(By.xpath(ReadProperties.get(PT))).click();
	}

	public void selectPackage(String pac) {
		driver.findElement(By.xpath(ReadProperties.get(pac))).click();
	}

	public void zipcodeRedirectDailyMenuWithPK(String dailyURL)
			throws InterruptedException {
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, dailyURL);
		Thread.sleep(3000);
		Assert.assertEquals(
				"disabled",
				driver.findElement(
						By.xpath(ReadProperties.get(Constant.E_DAILYPK)))
						.getAttribute("class"));
		Assert.assertEquals(
				"",
				driver.findElement(
						By.xpath(ReadProperties.get(Constant.E_DAILYDELI)))
						.getAttribute("class"));
	}

	public void zipcodeRedirectRP(String regiURL) {
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, regiURL);
	}

}
