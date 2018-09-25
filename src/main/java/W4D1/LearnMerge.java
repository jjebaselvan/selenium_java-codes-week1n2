package W4D1;

import java.awt.font.OpenType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LearnMerge {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");
		driver.findElementByXPath("//input[@id='username']").sendKeys("DemoSalesManager");
		driver.findElementByXPath("//input[@id='password']").sendKeys("crmsfa");
		driver.findElementByXPath("//input[@class='decorativeSubmit']").click();
		driver.findElementByXPath("//a[contains(text(),'CRM/SFA')]").click();
		driver.findElementByXPath("//a[contains(text(),'Leads')]").click();
		driver.findElementByLinkText("Merge Leads").click();
		driver.findElementByXPath("(//table[@id='widget_ComboBox_partyIdFrom']/following::img)[1]").click();

		Set<String> allwindowhandles = driver.getWindowHandles();

		System.out.println(allwindowhandles.size());

		List<String>  listofwindow= new ArrayList<String>();

		listofwindow.addAll(allwindowhandles);

		//switching to window2

		String window2 = listofwindow.get(1);
		driver.switchTo().window(window2);
		
		
		

		System.out.println("Title of window 2 is "+driver.getTitle());
		System.out.println("Window 2 URL "+driver.getCurrentUrl());

		driver.findElementByXPath("(//input[contains(@class,'x-form-text x-form-field')])[1]").sendKeys("10149");

		driver.findElementByXPath("(//button[contains(@class,'x-btn-text')])[1]").click();


		//WebDriverWait refreshwaiting = new WebDriverWait(driver, 120);

		//refreshwaiting.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'x-grid3-cell-inner x-grid3-col-partyId')]/a"))).click();

		Thread.sleep(500);
		driver.findElementByXPath("//div[contains(@class,'x-grid3-cell-inner x-grid3-col-partyId')]/a").click();
		//switch to  window1
		String window1 = listofwindow.get(0);
		driver.switchTo().window(window1);
		System.out.println("Title of window 1 is "+driver.getTitle());
		System.out.println("Window 1 URL "+driver.getCurrentUrl());


		driver.findElementByXPath("(//table[@id='widget_ComboBox_partyIdTo']/following::img)[1]").click();




		/*driver.findElementByXPath("((//input[contains(@class,'x-form-text x-form-field')])[1]").sendKeys("10634");

		driver.findElementByXPath("(//button[contains(@class,'x-btn-text')])[1]").click();


		WebDriverWait refreshwaiting1 = new WebDriverWait(driver, 120);
		refreshwaiting1.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'x-grid3-cell-inner x-grid3-col-partyId')]/a"))).click();
		 */		//switching to window3

		Set<String> allwindowhandles1 = driver.getWindowHandles();
		List<String>  listofwindow3= new ArrayList<String>();

		listofwindow3.addAll(allwindowhandles1);


		String window3 = listofwindow3.get(1);
		driver.switchTo().window(window3);

		System.out.println(driver.getTitle());

		driver.findElementByXPath("(//input[contains(@class,'x-form-text x-form-field')])[1]").sendKeys("10150");

		driver.findElementByXPath("(//button[contains(@class,'x-btn-text')])[1]").click();

		Thread.sleep(500);
		//WebDriverWait refreshwaiting11 = new WebDriverWait(driver, 120);
		//refreshwaiting11.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'x-grid3-cell-inner x-grid3-col-partyId')]/a"))).click();

		driver.findElementByXPath("//div[contains(@class,'x-grid3-cell-inner x-grid3-col-partyId')]/a").click();

		//switching to primary window

		String window4 = listofwindow.get(0);
		driver.switchTo().window(window4);





		driver.findElementByXPath("//a[contains(@class,'buttonDangerous')]").click();

		//handling alert

		driver.switchTo().alert().accept();


		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByXPath("(//input[contains(@class,'x-form-text x-form-field')])[28]").sendKeys("10149");
		driver.findElementByXPath("(//button[contains(@class,'x-btn-text')])[7]").click();

		//verify
		String verify = driver.findElementByXPath("//div[text()='No records to display']").getText();

		System.out.println(verify);

		String content ="No records to display";

		if (verify == content){

			System.out.println("Lead has been merged and cannot be found");
		}
		else
		{
			System.out.println("Lead has not been merged");
		}



		//taking snap

		File source = driver.getScreenshotAs(OutputType.FILE);
		File Des = new File ("./snaps/snap.png");

		FileUtils.copyFile(source, Des);

		driver.close();

	}

}
