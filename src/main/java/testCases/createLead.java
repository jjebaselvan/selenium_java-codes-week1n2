package testCases;

	




	import org.openqa.selenium.WebElement;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;
	import framework.SeMethods;



	public class createLead extends SeMethods {
		
		//@Test(invocationCount= 2, invocationTimeOut = 30000)
			@Test(groups="smoke", dataProvider = "createlead")
		public void createlead(String cName, String fName, String lName, String email, String ph) {
			startApp("chrome", "http://leaftaps.com/opentaps");
			WebElement eleUserName = locateElement("id", "username");
			type(eleUserName, "DemoSalesManager");
			WebElement elePassword = locateElement("id","password");
			type(elePassword, "crmsfa");
			WebElement eleLogin = locateElement("class","decorativeSubmit");
			click(eleLogin);
			
		WebElement crmlink = locateElement("LinkText", "CRM/SFA");
		click(crmlink);
		
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
		
		
		
		@DataProvider(name ="createlead")
		public Object[][] getdata(){
		 Object[][] data = new Object[2][5];
		 
		 data[0][0]= "citicorp";
		 data[0][1]= "Sheeba";
		 data[0][2]= "B";
		 data[0][3]= "SB@gmail.com";
		 data[0][4]= "123";
				 
		 data[1][0]= "citicorp";
		 data[1][1]= "jeba";
		 data[1][2]= "J";
		 data[1][3]= "Js@gmail.com";
		 data[1][4]= "123";		 
				 
		 return data;
	}
	}

