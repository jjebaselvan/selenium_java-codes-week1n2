package testCases;



	import org.openqa.selenium.WebElement;
	import org.testng.annotations.Test;

	import framework.SeMethods;



	public class editLead  extends SeMethods{
		

		//@Test(dependsOnMethods= "testcases.test_createlead.createlead", priority = 2)
		//@Test(groups="sanity", dependsOnGroups="smoke")
		
		
		public void editlead() throws InterruptedException {

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
			WebElement leadname = locateElement("xpath", "(//input[@name = 'firstName'])[3]");
			type(leadname, "Sheeba");
			WebElement filtrlead = locateElement("xpath", "//button[text() = 'Find Leads']");
			click(filtrlead);
			Thread.sleep(5000);
			WebElement pickalead = locateElement("xpath", "//td[@class = 'x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a");
			click(pickalead);
			String expectedTitle = driver.getTitle();
			verifyTitle(expectedTitle);
			WebElement editlink = locateElement("LinkText", "Edit");
			click(editlink);
			WebElement updtcompname = locateElement("id", "updateLeadForm_companyName");
			updtcompname.clear();
			String text = "citicorp";
			type(updtcompname, text);
			WebElement updatelead = locateElement("xpath", "//input[@value = 'Update']");
			click(updatelead);
			WebElement updatedcmpnyname = locateElement("id", "viewLead_companyName_sp");
			String Actualcmpnyname = updatedcmpnyname.getText();
			//Verify the Expected & Actual
			if(Actualcmpnyname.contains(text))
			{
				System.out.println("Verification of Company Name is Success");
			}else
				System.out.println("Verification of Company Name is Failed");
			
			System.out.println("edit lead executed");
			driver.close();
		}
		
	}
	


