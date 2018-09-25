package framework;

import java.io.File;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.sound.midi.SysexMessage;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;



public class SeMethods implements WdMethods{
	
	
	public int i = 1;
	public RemoteWebDriver driver;

	
	
	
	
	
	
	public void startApp(String browser, String url) {
		try {
			if(browser.equalsIgnoreCase("chrome")){
				
				ChromeOptions options = new ChromeOptions();
				
				options.addArguments("--disable-notifications");
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver(options);
				
				
				
			} else if (browser.equalsIgnoreCase("firefox")){
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("The Browser "+browser+" Launched Successfully");
		} catch (WebDriverException e) {
			System.err.println("The Browser "+browser+" not Launched");
		} finally {
			takeSnap();
		}

	}

	
	public WebElement locateElement(String locator, String locValue) {
		try {
			switch(locator) {
			case "id"	 : return driver.findElementById(locValue);
			case "class" : return driver.findElementByClassName(locValue);
			case "LinkText" : return driver.findElementByLinkText(locValue);
			case "xpath" : return driver.findElementByXPath(locValue);
			}
		} catch (NoSuchElementException e) {
			System.err.println("The Element is not found");
		} catch (Exception e) {
			System.err.println("Unknow Exception ");
		}
		return null;
	}

	@Override
	public WebElement locateElement(String locValue) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void type(WebElement ele, String data) {
		try {
			ele.sendKeys(data);
			System.out.println("The data "+data+" is Entered Successfully");
		} catch (WebDriverException e) {
			System.out.println("The data "+data+" is Not Entered");
		} finally {
			takeSnap();
		}
	}

	
	public void clickWithNoSnap(WebElement ele) {
		try {
			ele.click();
			System.out.println("The Element "+ele+" Clicked Successfully");
		} catch (Exception e) {
			System.err.println("The Element "+ele+"is not Clicked");
		}
	}
	
	
	@Override
	public void click(WebElement ele) {
		try {
			ele.click();
			System.out.println("The Element "+ele+" Clicked Successfully");
		} catch (WebDriverException e) {
		System.err.println("The Element "+ele+"is not Clicked");
		} finally {
			takeSnap();
		}
	}

	@Override
	public String getText(WebElement ele) {
		ele.getText();
		return null;
		
	}

	@Override
	public void selectDropDownUsingText(WebElement ele, String value) {
		try {
			Select dd = new Select(ele);
			dd.selectByVisibleText(value);
			System.out.println("The DropDown Is Selected with VisibleText "+value);
		} catch (Exception e) {
			System.err.println("The DropDown Is not Selected with VisibleText "+value);
		} finally {
			takeSnap();
		}

	}

	@Override
	public void selectDropDownUsingIndex(WebElement ele, int index) {
		try {
			Select dd = new Select(ele);
			dd.deselectByIndex(index);
			System.out.println("The DropDown Is Selected with index "+index);
		} catch (Exception e) {
			System.err.println("The DropDown Is not Selected with index "+index);
		} finally {
			takeSnap();
		}
		
	}

	@Override
	public boolean verifyTitle(String expectedTitle) {
		try {
			String title = driver.getTitle();
			if (title.contains(expectedTitle))
			{
				System.out.println("browser title matches with expected title");
			}
		} catch (Exception e) {
			System.err.println("browser title DOES NOT match with the expected title");
			
		}
		
		
		
		return false;
	}

	@Override
	public void verifyExactText(WebElement ele, String expectedText) {
		try {
			String text = ele.getText();
				
				if (text.equalsIgnoreCase(expectedText))
				{
					System.out.println("Expected Text matches with Given Text");
				}
		} catch (Exception e) {
			System.err.println("Expected Text DOES NOT match with Given Text");
		}
		
		

	}

	@Override
	public void verifyPartialText(WebElement ele, String expectedText) {
		
		try {
		String text = ele.getText();
		
		if (text.equalsIgnoreCase(expectedText))
		{
			System.out.println("Expected Text matches with Given Text");
		}
} catch (Exception e) {
	System.err.println("Expected Text DOES NOT match with Given Text");
}

	}

	@Override
	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void verifySelected(WebElement ele) {
		// TODO Auto-generated method stub

	}

	@Override
	public void verifyDisplayed(WebElement ele) {
		// TODO Auto-generated method stub

	}
	
	
	@Override
	public void switchToWindow(int index) {
		
		Set<String> Set = driver.getWindowHandles();
		List<String> List= new ArrayList<String>();
		
		
		String window = List.get(index);
		
		driver.switchTo().window(window);
		//System.out.println("Title of Current Window is "+driver.getTitle());
		
		
		

	}

	@Override
	public void switchToFrame(WebElement ele) {
		
		
		driver.switchTo().frame(ele);
		
		
		
		

	}
	
	@Override 
	public void dragndrop(WebElement ele, int x, int y) {
		
Actions builder = new Actions(driver);
		
		builder.dragAndDropBy(ele, x, y).perform();
	}

	@Override
	public void acceptAlert() {
		driver.switchTo().alert().accept();

	}

	@Override
	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}

	@Override
	public String getAlertText() {
		String text = driver.switchTo().alert().getText();
		System.out.println(text);
		return null;
	}

	
	public void takeSnap() {
		File src = driver.getScreenshotAs(OutputType.FILE);
		File des = new File("./snaps/img"+i+".png");
		try {
			FileUtils.copyFile(src, des);
		} catch (IOException e) {
			System.err.println("IOException");
		}
		i++;
	}

	@Override
	public void closeBrowser() {
		driver.close();
	}

	@Override
	public void closeAllBrowsers() {
		driver.quit();

	}


			
	

}
