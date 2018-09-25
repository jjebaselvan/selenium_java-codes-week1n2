package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import framework.SeMethods;

public class practise extends SeMethods {
	
	@Test
	public void testcase() {

	startApp("chrome", "http://leaftaps.com/opentaps");
	WebElement eleUserName = locateElement("id", "username");
	type(eleUserName, "DemoSalesManager");
	WebElement elePassword = locateElement("id","password");
	type(elePassword, "crmsfa");
	WebElement eleLogin = locateElement("class","decorativeSubmit");
	click(eleLogin);
	
	
	verifyTitle("Leaftaps - testleaf automation ");
	
	WebElement cliccrm = locateElement("LinkText", "CRM/SFA");

	verifyExactText(cliccrm, "CRM/S");
}
}