package W4D1;



	import java.io.IOException;

	import org.testng.annotations.AfterSuite;
	import org.testng.annotations.BeforeSuite;
	import org.testng.annotations.Test;

	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.MediaEntityBuilder;
	import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

	public class Learnreport {
		
		public static ExtentTest test;
		public static ExtentReports editablereport;
		public static String TCname, desc, author, category;
		
		

	@BeforeSuite
		public void beforesuite() {
			ExtentHtmlReporter noneditablereport = new ExtentHtmlReporter("D:\\TestLeaf\\Selenium\\reports\\a.html");

			noneditablereport.setAppendExisting(true);

		editablereport = new ExtentReports();

			editablereport.attachReporter(noneditablereport);
		}



	public void beforemethod() {
		
		
		test = editablereport.createTest(TCname, desc);

		test.assignAuthor(author);
		test.assignCategory(category);	

	}


		@Test
		public  void testreport()  {

				if 
			test.pass("Username entered successfully" );
			test.pass("Password Entered Sucecssfully");
			test.fail("Logged in");
		}
			
			@AfterSuite
			public void AfterSuite() {
			editablereport.flush();
			}

		

	}


