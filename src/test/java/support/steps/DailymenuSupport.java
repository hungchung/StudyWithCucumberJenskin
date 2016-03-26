package support.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;

import cucumber.api.DataTable;
import support.datas.Constant;
import support.utils.ReadProperties;
import support.utils.ElementHelper;

public class DailymenuSupport extends CuchineSupport {

	private ElementHelper El;
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

	public void clickGotit() {
		driver.findElement(By.xpath(ReadProperties.get(Constant.E_GOTITUP)))
				.click();
	}

	public void clickonCurrentDate() {
		driver.findElement(By.xpath(ReadProperties.get(Constant.E_DMDATEDF)))
				.click();

	}

	public void clickDate() {
		driver.findElement(By.xpath(ReadProperties.get(Constant.E_DMDATE)))
				.click();
	}

	public void getdataTb(List<List<String>> dataTb) {
		this.dataTb = dataTb;
	}

	public void comparedata(String date, String data, List<List<String>> tb) {
		/*if (driver.findElement(By.xpath(ReadProperties.get(Constant.E_DMDATE)))
				.getText() == date) {*/
			
			 //assert Chef
			  Assert.assertEquals(tb.get(Integer.parseInt(data.substring(0, 1))).get(1),driver.findElement(By.xpath(ReadProperties
			       .get(Constant.E_XDINNERCH1))).getText());
		Assert.assertEquals(
			     tb.get(Integer.parseInt(data.substring(2, 2))).get(1),
			     driver.findElement(By.xpath(ReadProperties
			       .get(Constant.E_XLAUNCHCH2))).getText());
			   Assert.assertEquals(
			     tb.get(Integer.parseInt(data.substring(5, 2))).get(1),
			     driver.findElement(By.xpath(ReadProperties
			       .get(Constant.E_XLAUNCHCH3))).getText());
			   Assert.assertEquals(
			     tb.get(Integer.parseInt(data.substring(8, 2))).get(1),
			     driver.findElement(By.xpath(ReadProperties
			       .get(Constant.E_XLAUNCHCH4))).getText());
			   
		}
	}

