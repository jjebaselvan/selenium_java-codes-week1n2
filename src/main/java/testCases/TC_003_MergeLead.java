package testCases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import framework.SeMethods;

public class TC_003_MergeLead extends SeMethods {
	
	
	@Test
	public void mergeLead()  {
	
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
		
		WebElement clicmergelead = locateElement("LinkText", "Merge Leads");
		click(clicmergelead);
		
		WebElement clickfrom = locateElement("xpath", "(//table[@name='ComboBox_partyIdFrom']/following::img)[1]");
		click(clickfrom);
		
		
		switchToWindow(1);
		
		
		
		
		WebElement clic1st = locateElement("xpath", "(//div[contains(@class,'x-grid3-col-partyId')]/a)[1]");
		click(clic1st);
		
		switchToWindow(0);
		
		
		WebElement clickto = locateElement("xpath", "(//table[@name='ComboBox_partyIdTo']/following::img)[1]");
		click(clickto);
		
		switchToWindow(1);
		

		WebElement clic2nd = locateElement("xpath", "(//div[contains(@class,'x-grid3-col-partyId')]/a)[2]");
		click(clic2nd);
		switchToWindow(0);
}
}
