package testCases;





	import org.openqa.selenium.WebElement;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;
	import framework.SeMethods;



	public class Test_DataProvider extends projectmethods {
		
		@BeforeTest(groups = "common")
		public void setData() {
			testCaseName = "TC001";
			testCaseDescription ="Create a lead";
			category = "Smoke";
			author= "Koushik";
			excelFileName="create Lead";
		}

		//@Test(invocationCount= 2, invocationTimeOut = 30000)
		@Test(/groups="smoke",/ dataProvider = "common")
		public void createlead(String cName, String fName, String lName, String email, String ph) {



			WebElement leadcreate = locateElement("LinkText", "Create Lead");
			click(leadcreate);
			WebElement compname = locateElement("id", "createLeadForm_companyName");
			type(compname, cName);
			WebElement frstname = locateElement("id", "createLeadForm_firstName");
			type(frstname, fName);
			String Expectdfrstname = frstname.getText();
			WebElement lastname = locateElement("id", "createLeadForm_lastName");
			type(lastname, lName);
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

			driver.close();

		}




	}