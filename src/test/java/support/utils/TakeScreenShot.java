package support.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;

public class TakeScreenShot {
	
	public String getOutputName(String namePage){		
		//file Name
		String[]spl = namePage.split("/");
		String name = spl[spl.length-1];
		DateFormat dateFormat = new SimpleDateFormat("MMM dd yyyy HH:mm:ss");
		Date date = new Date();
		name = name +"-"+ dateFormat.format(date).toString();// +".png";
		name = name.replaceAll(":", "");
		return name + ".png";
	}
	
	public BufferedImage takeAShot(WebDriver driver) throws IOException{
		final Screenshot screenshot = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
		final BufferedImage image = screenshot.getImage();
		return image;
	}
	
	public File takeScreenShot(WebDriver driver) throws IOException{
		//get height
		JavascriptExecutor js=(JavascriptExecutor) driver;
		String hg = (String)js.executeScript("return document.documentElement.clientHeight +':'+  document.body.scrollHeight;");
		String[] hgs = hg.split(":");
		int hv = Integer.parseInt(hgs[0]);
		int ha = Integer.parseInt(hgs[1]);
		int loop = (ha + (hv-1))/hv; // division round up
		List<File> imgs = new ArrayList<File>();
		for (int i = 0; i < loop; i++) {
			//sroll to position to screen shot
			js.executeScript("scrollBy(0,"+ (i*hv) +");");
			//take screenshot
			File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			imgs.add(scr);
		}
		return mergeImage(imgs);
		
	}
	
	private File mergeImage(List<File> imgs){
		return new File("");
	}
}
