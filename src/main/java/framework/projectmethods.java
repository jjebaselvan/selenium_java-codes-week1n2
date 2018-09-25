package framework;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import framework.SeMethods;
import testCases.Excel_integration;

public class projectmethods extends SeMethods {
	@BeforeMethod
	public void login() {
		startApp("chrome", "http://leaftaps.com/opentaps");
		WebElement eleUserName = locateElement("id", "username");
		type(eleUserName, "DemoSalesManager");
		WebElement elePassword = locateElement("id","password");
		type(elePassword, "crmsfa");
		WebElement eleLogin = locateElement("class","decorativeSubmit");
		click(eleLogin);
		WebElement crmlink = locateElement("LinkText", "CRM/SFA");
		click(crmlink);
	}

	@AfterMethod
	public void closebrowser() {

		closeAllBrowsers();

	}	


	@DataProvider(name ="common")
	public Object[][] getdata() throws IOException{
		return Excel_integration.getExcelData(excelFileName);


	}




}