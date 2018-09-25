package testCases;



	import org.openqa.selenium.WebElement;
	import org.testng.annotations.Test;

	import framework.SeMethods;



	public class DeleteLead extends SeMethods {

		//@Test(dependsOnMethods= "testcases.test_createlead.createlead", priority = 1)
		//@Test(groups="regression", dependsOnGroups= "sanity")

		
		public void deleteLead() throws InterruptedException {
			startApp("chrome", "http://leaftaps.com/opentaps");
			WebElement eleUserName = locateElement("id", "username");
			type(eleUserName, "DemoSalesManager");
			WebElement elePassword = locateElement("id","password");
			type(elePassword, "crmsfa");
			WebElement eleLogin = locateElement("class","decorativeSubmit");
			click(eleLogin);
			
			
			
			
			WebElement crmlink = locateElement("LinkText", "CRM/SFA");
			click(crmlink);
			WebElement leadmenu = locateElement("LinkText", "Leads");
			click(leadmenu);
			WebElement findlead = locateElement("xpath", "//a[text() = 'Find Leads']");
			click(findlead);
			
			
			WebElement leadid = locateElement("xpath", "(//input[contains(@class,' x-form-text')])[29]");
			type(leadid, "sheeba");
			
			WebElement findleads = locateElement("xpath", "(//button[contains(@class,'x-btn-text')])[7]");
			click(findleads);
			
			
			Thread.sleep(2500);
			
			
			WebElement firstlead = locateElement("xpath","(//a[@class='linktext'])[4]");
			click(firstlead);
			
			
			
			WebElement deletelink = locateElement("LinkText", "Delete");
			click(deletelink);
			
			System.out.println("delete lead executed");
			
			driver.close();
			
			
			
			
		}
	}
