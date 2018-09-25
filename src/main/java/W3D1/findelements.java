package W3D1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class findelements {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("htt/p:/leaftaps.com/opentaps/");
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.manage().timeouts().implicitlyWait(999999999, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("")));
		
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Create Lead").click();
		driver.findElementById("createLeadForm_companyName").sendKeys("CTS");
		driver.findElementById("createLeadForm_firstName").sendKeys("Jebaselvan");
		driver.findElementById("createLeadForm_lastName").sendKeys("j");
		
		
		/*WebElement src = driver.findElementById("createLeadForm_dataSourceId");
		Select dd = new Select(src);
		dd.selectByVisibleText("Employee");*/
		
		WebElement js = driver.findElementById("createLeadForm_dataSourceId");
		Select jeba = new Select(js);
		jeba.selectByVisibleText("Direct Mail");
		
		
		
		WebElement vichu = driver.findElementById("createLeadForm_marketingCampaignId");
		Select selvan=new Select(vichu);
		selvan.selectByValue("CATRQ_AUTOMOBILE");
		WebElement sheeba = driver.findElementById("createLeadForm_currencyUomId");
		Select jebaselvan=new Select(sheeba);
		jebaselvan.selectByIndex(70);
		
		driver.findElementByClassName("smallSubmit").click();
		
	}

}
