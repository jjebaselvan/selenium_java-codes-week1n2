package testCases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import framework.SeMethods;

public class TC005_faceBook extends SeMethods{
	
	String button = "Like";
	@Test
	public void fb() throws InterruptedException {

		startApp("chrome", "https://www.facebook.com/");

		//entering emailID

		WebElement email = locateElement("xpath", "//input[@id='email']");
		email.sendKeys("jebahsd@gmail.com");

		//entering password

		WebElement password = locateElement("xpath", "//input[@id='pass']");
		password.sendKeys("jeba1234");
		
		//click Login

		WebElement login = locateElement("xpath", "//input[@type='submit']");
	
		login.click();
		
		Thread.sleep(5000);
		
		
		
		
		// entering text in search bar
		
		WebElement search = locateElement("xpath", "//input[@class='_1frb']");
		search.sendKeys("TestLeaf");
		
		WebElement find = locateElement("xpath", "//i[@class='_585_']");
		find.click();
		find.click();
				
		WebElement likebutton = locateElement("xpath", "(//div[text()='TestLeaf']/following::button[@type='submit'])[1]");
		
		System.out.println(likebutton.getText());
		
		
		String verifylike = likebutton.getText();
		
		if (verifylike.equals(button)) {
			
			likebutton.click();
			
			System.out.println("Like button has been clicked");
		}

		else {
			System.out.println("page is already liked");
		}
		
		
		WebElement clickontestleaf = locateElement("LinkText", "TestLeaf");
		clickontestleaf.click();
		
		
		
		WebElement peoplelike = locateElement("xpath", "(//div[contains(@class,'_4bl9')]/div)[4]");
		
		 String displaylikes = peoplelike.getText();
		 
		 System.out.println(displaylikes);
		 
		 
		 verifyTitle("TestLeaf");
		 
		 
		 closeBrowser();
		 
		 
	}



}
