package W4D1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWindows {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.Exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByLinkText("Contact Us").click();

		Set<String> allwindowhandles = driver.getWindowHandles();

		System.out.println(allwindowhandles.size());

		List<String>  listofwindow= new ArrayList<String>();

		listofwindow.addAll(allwindowhandles);

		String window2 = listofwindow.get(1);

		System.out.println(window2);

		driver.switchTo().window(window2);

		System.out.println("Title of window 2 is "+driver.getTitle());
		System.out.println("Window 2 URL "+driver.getCurrentUrl());
		driver.quit();

	}

}
