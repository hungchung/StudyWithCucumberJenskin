package support.steps;

import org.junit.Assert;
import org.openqa.selenium.By;

import support.datas.Constant;
import support.utils.ReadProperties;

public class LandingPageSupport extends CuchineSupport {

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

	public void zipcodeErrorMsg(String errorMs) {
		try {
			Assert.assertEquals(
					errorMs,
					driver.findElement(
							By.xpath(ReadProperties
									.get(Constant.E_ZIPCODEERRORMSG2)))
							.getText());
		} catch (Exception e) {
			Assert.assertEquals(errorMs, "");
		}
	}

	public void ladingClickLogo() {
		driver.findElement(By.xpath(ReadProperties.get(Constant.E_LANDINGLOGO)))
				.click();
	}

	public void landingDisplayedCorrectURL(String landingURL) {
		String url = driver.getCurrentUrl();
		Assert.assertEquals(landingURL, url);

	}

	public void landingOurPhilClick() {
		driver.findElement(
				By.xpath(ReadProperties.get(Constant.E_LANDINGOURPHIL)))
				.click();
	}

	public void landingHowItClick() {
		driver.findElement(
				By.xpath(ReadProperties.get(Constant.E_LANDINGHOWIT))).click();
	}

	public void landingCookWithClick() {
		driver.findElement(
				By.xpath(ReadProperties.get(Constant.E_LANDINGCOOKWITH)))
				.click();

	}

	public void zipcodeRedirectDailyMenuWithPK(String dailyURL)
			throws InterruptedException {
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, dailyURL);
		Thread.sleep(3000);
		/*driver.findElement(By.xpath(ReadProperties.get(Constant.E_GOTITUP)))
		.click();*/
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
