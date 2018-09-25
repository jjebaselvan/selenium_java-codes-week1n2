package W3D1;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class IRCTC {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/nget/train-search");
		//driver.findElementByClassName("ng-star-inserted");
		driver.findElementByLinkText("AGENT LOGIN").click();
		driver.findElementByLinkText("Sign up").click();
		driver.findElementById("userRegistrationForm:userName").sendKeys("Jebaselvan");
		driver.findElementById("userRegistrationForm:password").sendKeys("metlife");
		driver.findElementById("userRegistrationForm:confpasword").sendKeys("metlife");
		
		/*WebElement jeba = driver.findElementById("userRegistrationForm:securityQ");
		Select js = new Select(jeba);
		js.selectByIndex(2);*/
		
		driver.findElementById("userRegistrationForm:securityAnswer").sendKeys("Bright");
		
		
		WebElement lang = driver.findElementById("userRegistrationForm:prelan");
		Select Lang1 = new Select(lang);
		Lang1.selectByVisibleText("English");
		
		
		
		driver.findElementById("userRegistrationForm:firstName").sendKeys("Jebaselvan");
		
		driver.findElementById("userRegistrationForm:gender:0").click();
		driver.findElementById("userRegistrationForm:maritalStatus:1").click();
		
		WebElement occupation = driver.findElementById("userRegistrationForm:occupation");
		Select occupation1 = new Select(occupation);
		occupation1.selectByIndex(4);
		
		WebElement country = driver.findElementById("userRegistrationForm:countries");
		Select country1 = new Select(country);
		country1.selectByIndex(1);
		driver.findElementById("userRegistrationForm:email").sendKeys("jeba_selvan@ymail.com");
		driver.findElementById("userRegistrationForm:mobile").sendKeys("8056655998");
		
		WebElement nationality = driver.findElementById("userRegistrationForm:nationalityId");
		Select nationality1 = new Select(nationality);
		nationality1.selectByIndex(1);
		
		driver.findElementById("userRegistrationForm:address").sendKeys("16 gandhi st avadi");
		
		driver.findElementById("userRegistrationForm:pincode").sendKeys("600071", Keys.TAB);
		Thread.sleep(3000);
		
		WebElement city = driver.findElementById("userRegistrationForm:cityName");
		Select city1 = new Select(city);
		city1.selectByIndex(1);
		Thread.sleep(4000);
		
		WebElement po = driver.findElementById("userRegistrationForm:postofficeName");
		Select po1 = new Select(po);
		po1.selectByIndex(2);
		
		
		driver.findElementById("userRegistrationForm:landline").sendKeys("04426550573");
		
		
	}

}
