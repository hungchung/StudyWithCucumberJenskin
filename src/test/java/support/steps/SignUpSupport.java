package support.steps;

import org.junit.Assert;
import org.openqa.selenium.By;

import support.datas.Constant;
import support.utils.ReadProperties;
import support.utils.ElementHelper;

public class SignUpSupport extends CuchineSupport {

	private ElementHelper El;

	public void openCuChinePage(String url) {
		driver.manage().deleteAllCookies();
		driver.navigate().to(url);
	}

	public void openSigup() {
		driver.findElement(By.xpath((ReadProperties.get(Constant.E_SIGNUPENT))))
				.click();
	}

	public void closePopUp() throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(By.xpath((ReadProperties.get(Constant.E_CLOSEPU))))
				.click();
	}

	public void checkClosePU() throws InterruptedException {
		Assert.assertEquals("overlay hidden", (driver.findElement(By
				.xpath(ReadProperties.get(Constant.E_CLOSEPUST)))
				.getAttribute("class")));
	}

	public void clickFBbtn() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath((ReadProperties.get(Constant.E_SUFBBTN))))
				.click();
	}

	public void logInonFBPU(String usr, String pw) throws InterruptedException {
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.findElement(By.xpath((ReadProperties.get(Constant.E_USRFB))))
				.clear();
		driver.findElement(By.xpath((ReadProperties.get(Constant.E_PWFB))))
				.clear();
		driver.findElement(By.xpath((ReadProperties.get(Constant.E_USRFB))))
				.sendKeys(usr);
		driver.findElement(By.xpath((ReadProperties.get(Constant.E_PWFB))))
				.sendKeys(pw);
		driver.findElement(By.xpath((ReadProperties.get(Constant.E_SMFB))))
				.click();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}

	public void signInFBEmail(String EFB) {
		driver.findElement(By.xpath((ReadProperties.get(Constant.E_MSI))))
				.sendKeys(EFB);
		driver.findElement(By.xpath((ReadProperties.get(Constant.E_SIBYEM))))
				.click();
	}

	public void fillUserInfo(String FN, String LN, String PN, String ZC,
			String PW, String PWC) {
		driver.findElement(
				By.xpath((ReadProperties.get(Constant.E_SIGNUPFIRSTNAME))))
				.clear();
		driver.findElement(
				By.xpath((ReadProperties.get(Constant.E_SIGNUPFIRSTNAME))))
				.sendKeys(FN);

		driver.findElement(
				By.xpath((ReadProperties.get(Constant.E_SIGNUPLASTNAME))))
				.clear();
		driver.findElement(
				By.xpath((ReadProperties.get(Constant.E_SIGNUPLASTNAME))))
				.sendKeys(LN);
		;

		driver.findElement(
				By.xpath((ReadProperties.get(Constant.E_SIGNUPHONE)))).clear();
		driver.findElement(
				By.xpath((ReadProperties.get(Constant.E_SIGNUPHONE))))
				.sendKeys(PN);

		driver.findElement(
				By.xpath((ReadProperties.get(Constant.E_SIGNUPZIPCODE))))
				.clear();
		driver.findElement(
				By.xpath((ReadProperties.get(Constant.E_SIGNUPZIPCODE))))
				.sendKeys(ZC);

		driver.findElement(By.xpath((ReadProperties.get(Constant.E_SIGNUPPW))))
				.clear();
		driver.findElement(By.xpath((ReadProperties.get(Constant.E_SIGNUPPW))))
	.sendKeys(PW);;
		
		driver.findElement(
				By.xpath((ReadProperties.get(Constant.E_SIGNUPPWCONFIRM))))
				.clear();		
		driver.findElement(
				By.xpath((ReadProperties.get(Constant.E_SIGNUPPWCONFIRM))))
			.sendKeys(PWC);;

		driver.findElement(
				By.xpath((ReadProperties.get(Constant.E_KEEPSINCHECKBOX))))
				.click();
		
		driver.findElement(
				By.xpath((ReadProperties.get(Constant.E_SIGNUPSUBMIT))))
				.click();

	}

}
