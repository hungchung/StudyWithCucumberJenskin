package support.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementHelper {

	public static WebElement findElement (WebDriver driver, String locator)
	{
		WebElement e = null;
		try
		{
			e = (driver.findElement(By.id(locator)));
			if(e != null)
			{
				return e;
				
			}
		}catch(Exception e1)
		{
			try
			{
				e = (driver.findElement(By.name(locator)));
				if(e != null)
				{
					return e;
				}
			}catch(Exception e2)
			{
				try
				{
					e = (driver.findElement(By.cssSelector(locator)));
					if(e != null)
					{
						return e;
					} 
				}catch(Exception e3)
				{
					try
					{
						e =(driver.findElement(By.xpath(locator)));
						if(e != null)
						{
							return e;
						}
					}catch(Exception e4)
					{
						try
						{
							e =  (driver.findElement(By.tagName(locator)));
							if(e != null)
							{
								return e;
							}
						}catch(Exception e5)
						{
							System.out.println("Could not find this element: "+locator);
							e5.printStackTrace();
						}
					}
				}
			}
		}
		
		return e;
	}
	
	public static WebElement findLink(WebDriver driver, String linktext)
	{
		WebElement e = null;
		try
		{
			return (driver.findElement(By.linkText(linktext)));
		}catch(Exception e1)
		{
			try
			{
				return (driver.findElement(By.partialLinkText(linktext)));
			}catch(Exception e2)
			{
				System.out.print("Could not find this element: " +linktext);
				e2.printStackTrace();
			}
		}
		return e;
	}
	
	public void sendKey(WebDriver driver,String locator, String value)
	{
		try
		{
			WebElement ele = findElement(driver,locator);
			ele.sendKeys(""+value);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
			
	}
	
	public void clickCheckBox(WebDriver driver,String locator)
	{
		WebElement e = null;
		e = ElementHelper.findElement(driver, locator);
		e.click();
	}
	
	public boolean isChecked(WebDriver driver, WebElement checkbox)
	{
		return checkbox.isSelected();
	}
}
