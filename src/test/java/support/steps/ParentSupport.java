package support.steps;

import java.net.URL;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import support.datas.Constant;
import support.datas.DataProvider;
import support.utils.ReadProperties;

public class ParentSupport {

	protected static WebDriver driver;
	/**
	 * @throws Exception 
	 *
	 */

	public ParentSupport(){
		String run = ReadProperties.get(Constant.RUN_ON);
		String browser = ReadProperties.get(Constant.RUN_BROWSER);
		
		switch (run) {
		case Constant.HOST_LOCAL:
			switch (browser) {
			case Constant.BROWSER_CHROME:
				createLocalChrome();
				break;
			case Constant.BROWSER_FIREFOX:
				createLocalFirefox();
				break;
			case Constant.BROWSER_IE:
				createLocalIE();
				break;
			default:
				createService(false);
			}
			break;
		case Constant.HOST_GRID:
			createGrid(browser);
			break;
		default:
			break;
		}
		
		
	}


	private Platform getPlatform(){
		String iso = ReadProperties.get(Constant.IOS_GRID);
		switch (iso) {
		case Constant.IOS_WINDOWN8:
			return Platform.WIN8;
		case Constant.IOS_WINDOWN8_1:
			return Platform.WIN8_1;
		case Constant.IOS_WINDOWN:
			return Platform.WINDOWS;
		case Constant.IOS_LINUX:
			return Platform.LINUX;
		case Constant.IOS_MAC:
			return Platform.MAC;
		default:
			return Platform.WINDOWS;
		}
	}
	
	private void setBrowserSize(){
		String size = ReadProperties.get(Constant.BROWSER_SIZE);
		switch (size) {
		case Constant.BROWSER_MAXIMUM:			
			driver.manage().window().maximize();
			break;
		default:
			String[] spl = size.split(Constant.REGEX);
			driver.manage().window().setPosition(new Point(0,0));
			driver.manage().window().setSize(new Dimension(Integer.parseInt(spl[0]) ,Integer.parseInt(spl[1])));
			break;
		}
	}
	
	private void createGrid(String browser){
		if(driver == null){
			try {
				DesiredCapabilities capa = new DesiredCapabilities();
				capa.setPlatform(getPlatform());
				capa.setBrowserName(browser);
				
				driver = new RemoteWebDriver(new URL(ReadProperties.get(Constant.GRID_HOST)), capa);
				setBrowserSize();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//https://code.google.com/p/selenium/wiki/Grid2
	}
	
	
	private void createLocalChrome(){
		if(driver == null){
			DataProvider dp = new DataProvider();
			String path = "";
			if (SystemUtils.IS_OS_WINDOWS) {
				killService("chromedriver_win_x64.exe");
				path = dp.getReferencesFile("chromedriver_win_x64.exe");
			} else {
				path = dp.getReferencesFile("chromedriver");
			}
			System.setProperty("webdriver.chrome.driver",path);
			driver = new ChromeDriver();
			setBrowserSize();
		}
	}

	private void killService(String name){
		try {
			Runtime.getRuntime().exec("taskkill /f /im "+ name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	private void createLocalIE() {
		if(driver == null){
			DataProvider dp = new DataProvider();
			String path = "";
			if (SystemUtils.IS_OS_WINDOWS) {
				boolean is64bit = System.getProperty("sun.arch.data.model").contains("64");
				if(is64bit){
					killService("IEDriverServer_win_x64.exe");
					path = dp.getReferencesFile("IEDriverServer_win_x64.exe");
					
				}else{
					killService("IEDriverServer_win_x32.exe");
					path = dp.getReferencesFile("IEDriverServer_win_x32.exe");
				}
			}
			System.setProperty("webdriver.ie.driver",path);
			driver = new InternetExplorerDriver();
			setBrowserSize();
		}
	}

	
	private void createLocalFirefox(){
		
		if(driver == null){
			driver = new FirefoxDriver();
			setBrowserSize();
		}
	}
	
	/**create with service driver, it's not open
	 * @param option enable javascript
	 */
	private void createService(boolean option){
		if(driver == null){
			 // turn off htmlunit warnings
		    java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(java.util.logging.Level.OFF); 
		    java.util.logging.Logger.getLogger("org.apache.http").setLevel(java.util.logging.Level.OFF);
		    System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
		    driver = new HtmlUnitDriver(option);
		}
	}


	//finalize for PC version 
	protected void finalize() throws Throwable {

		try {
			String name = null;
			if (driver instanceof ChromeDriver)
				name = ReadProperties.get(Constant.BROWSER_CHROMEDRIVER_WIN);
			if (driver instanceof InternetExplorerDriver) {
				boolean is64bit = System.getProperty("sun.arch.data.model")
						.contains("64");
				if (is64bit) {
					name = ReadProperties.get(Constant.BROWSER_IEDRIVER_WIN64);
				} else {
					name = ReadProperties.get(Constant.BROWSER_IEDRIVER_WIN32);
				}
			}
			killService(name);
			driver.close();
		} finally {
			super.finalize();
		}
	}
	
	public void driverClear(){
		driver.manage().deleteAllCookies();
	}
}
