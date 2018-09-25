package W3D2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class duplicatenedit {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");
		driver.findElementByXPath("//input[@id='username']").sendKeys("DemoSalesManager");
		driver.findElementByXPath("//input[@id='password']").sendKeys("crmsfa");
		driver.findElementByXPath("//input[@class='decorativeSubmit']").click();
		driver.findElementByXPath("//a[contains(text(),'CRM/SFA')]").click();
		driver.findElementByXPath("//a[contains(text(),'Leads')]").click();
		driver.findElementByXPath("//a[contains(text(),'Find Leads')]").click();
		driver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys("jeba");
		driver.findElementByXPath("//button[contains(text(),'Find Leads')]").click();

		WebDriverWait refreshwaiting = new WebDriverWait(driver, 120);

		refreshwaiting.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]"))).click();

		driver.findElementByXPath("(//a[@class='subMenuButton'])[3]").click();
		driver.findElementByXPath("//input[@id='updateLeadForm_generalProfTitle']").clear();
		driver.findElementByXPath("//input[@id='updateLeadForm_generalProfTitle']").sendKeys("CTSprofile");
		driver.findElementByXPath("(//input[@type='submit'])[1]").click();

		/*WebElement table = driver.findElementByXPath("//div[@class='fieldgroup-body']");

		List<WebElement> trow = table.findElements(By.tagName("tr"));

		System.out.println(table.findElements(By.tagName("tr")).get(5).getText());

		List<WebElement> trow = table.findElements(By.tagName("tr"));

		System.out.println(trow);


		for (WebElement trow1 : trow) {

			System.out.println(trow1.findElements(By.tagName("td")).get(1).getText());
*/

			driver.close();

		}
	}


