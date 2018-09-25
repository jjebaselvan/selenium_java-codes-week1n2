package testCases;




	import org.openqa.selenium.WebElement;
	import org.testng.annotations.Parameters;
	import org.testng.annotations.Test;
	import framework.SeMethods;



	public class Test_Parameters  extends SeMethods {

		//@Test(invocationCount= 2, invocationTimeOut = 30000)



		@Test(groups="smoke")
		@Parameters({"browser", "url", "username", "password"})
		public void createlead(String browser, String url, String username, String password) {
			startApp(browser, url);
			WebElement eleUserName = locateElement("id", "username");
			type(eleUserName, username);
			WebElement elePassword = locateElement("id","password");
			type(elePassword, password);



			WebElement eleLogin = locateElement("class","decorativeSubmit");
			click(eleLogin);

			WebElement crmlink = locateElement("LinkText", "CRM/SFA");
			click(crmlink);

			WebElement leadcreate = locateElement("LinkText", "Create Lead");
			click(leadcreate);
			WebElement compname = locateElement("id", "createLeadForm_companyName");
			type(compname, "CTS");
			WebElement frstname = locateElement("id", "createLeadForm_firstName");
			type(frstname, "sheeba");
			String Expectdfrstname = frstname.getText();
			WebElement lastname = locateElement("id", "createLeadForm_lastName");
			type(lastname, "B");
			WebElement drpdwn = locateElement("id", "createLeadForm_dataSourceId");
			selectDropDownUsingText(drpdwn, "Employee");
			WebElement submit = locateElement("class","smallSubmit");
			click(submit);
			WebElement frstnamecreatd = locateElement("id", "viewLead_firstName_sp");
			String Actualfrstname = frstnamecreatd.getText();
			//Verify the Expected & Actual
			if(Actualfrstname.contains(Expectdfrstname))
			{
				System.out.println("Verification of First Name is Success");
			}else
				System.out.println("Verification of First Name is Failed");


			System.out.println("create lead executed");
			driver.close();

		}
	

}
