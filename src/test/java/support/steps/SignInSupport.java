package support.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import support.datas.Constant;
import support.utils.ReadProperties;

public class SignInSupport extends CuchineSupport {

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

	public void closePopUp() {
		driver.findElement(By.xpath((ReadProperties.get(Constant.E_CLOSESIUP))))
				.click();
	}

	public void checkClosePU() throws InterruptedException {
		Thread.sleep(1000);
		Assert.assertEquals("overlay hidden", (driver.findElement(By
				.xpath(ReadProperties.get(Constant.E_CLOSEPUST)))
				.getAttribute("class")));
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

	public void checkSignSuccessful(String URL) {
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, URL);
	}

	public void checkValidation(String Err) {
		try {
			WebElement element = driver.findElement(By.xpath(ReadProperties
					.get(Constant.E_SIGEMERR)));
			if (null != element && element.isDisplayed()) {
				Assert.assertEquals(
						Err,
						driver.findElement(
								By.xpath(ReadProperties
										.get(Constant.E_SIGEMERR))).getText());
			}

		} catch (Exception e) {
			Assert.assertEquals(
					Err,
					driver.findElement(
							By.xpath(ReadProperties.get(Constant.E_SIGERR)))
							.getText());
		}
	}

	public void checkKeepSI() {
		driver.findElement(By.xpath(ReadProperties.get(Constant.E_KSI)))
				.click();
	}

	/*
	 * public void reOpenbrowser(String url){ driver.close();
	 * driver.navigate().to(url); }
	 */
	public void clickSIFB() {
		driver.findElement(By.xpath((ReadProperties.get(Constant.E_SIGNINFB))))
				.click();
	}

	public void signInFB(String Email, String Pw) {
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.findElement(By.xpath((ReadProperties.get(Constant.E_FBUSR))))
				.clear();
		driver.findElement(By.xpath((ReadProperties.get(Constant.E_FBPW))))
				.clear();
		driver.findElement(By.xpath(ReadProperties.get(Constant.E_FBUSR)))
				.sendKeys(Email);
		driver.findElement(By.xpath(ReadProperties.get(Constant.E_FBPW)))
				.sendKeys(Pw);
		driver.findElement(By.xpath(ReadProperties.get(Constant.E_FBBTN)))
		.click();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}

	public void clickSIFBPU() {
		driver.findElement(By.xpath(ReadProperties.get(Constant.E_FBBTN)))
				.click();
	}

	public void checkRedirectionAccountInfo(String URL) {
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, URL);
	}
	public void checkValidationWithFB(String Errmes){
		Assert.assertEquals(Errmes, driver.findElement(
				By.xpath(ReadProperties.get(Constant.E_FBERR)))
				.getText());
	} 
}
