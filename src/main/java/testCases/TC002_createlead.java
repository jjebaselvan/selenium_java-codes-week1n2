package testCases;

import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

import framework.SeMethods;

public class TC002_createlead extends SeMethods {
	@Test
	public void createlead() {
	
		startApp("chrome", "http://leaftaps.com/opentaps");
		WebElement eleuser = locateElement("id", "username");
		type(eleuser, "DemoSalesManager");
		WebElement elepwd = locateElement("id", "password");
		type(elepwd, "crmsfa");
		WebElement eleclic = locateElement("class", "decorativeSubmit");
		click(eleclic);
		WebElement cliccrm = locateElement("LinkText", "CRM/SFA");
		click(cliccrm);
		WebElement clicreatelead = locateElement("LinkText", "Create Lead");
		click(clicreatelead);
		WebElement comname = locateElement("id", "createLeadForm_companyName");
		type(comname, "CTS");
		
		WebElement firname = locateElement("id", "createLeadForm_firstName");
		type(firname, "Sheeba");
		
		WebElement lasname = locateElement("id", "createLeadForm_lastName");
		type(lasname, "Bheemavarapu");
		
		WebElement dropname = locateElement("id", "createLeadForm_currencyUomId");
		
		selectDropDownUsingText(dropname, "INR - Indian Rupee");
		
		WebElement cliccreate = locateElement("xpath", "//input[contains(@class,'smallSubmit')]");
		click(cliccreate);
		
		
}
}