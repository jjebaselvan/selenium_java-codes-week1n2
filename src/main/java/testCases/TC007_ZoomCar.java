package testCases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import framework.SeMethods;

public class TC007_ZoomCar extends SeMethods{
	@Test
	public void ZoomCar() throws InterruptedException {

		startApp("chrome", "https://www.zoomcar.com/chennai/");

		WebElement search = locateElement("xpath", "//a[@class='search']");
		search.click();

		WebElement manikam = locateElement("xpath","(//div[@class='component-popular-locations']/div)[3]");
		manikam.click();


		WebElement next = locateElement("xpath","//button[text()='Next']");
		next.click();
		Thread.sleep(2000);

		WebElement day= locateElement("xpath","//div[contains(text(),'Mon')]");
		//System.out.println(day.getText());
		day.click();




		//	WebElement verify = locateElement("xpath","//div[contains(@class,'day picked')]/div");
		//


		WebElement next1 = locateElement("xpath","//button[text()='Next']");
		next1.click();

		//verifyExactText(day, "Mon");

		WebElement done = locateElement("xpath","//button[@class='proceed']");
		done.click();

		Thread.sleep(3000);

		List<WebElement> carlist = driver.findElementsByXPath("//div[@class='price']");

		System.out.println(carlist.size());


		/*WebElement price1 = locateElement("xpath", "//div[@class='price']");

		System.out.println(price1.getText());*/



		List<Integer> list = new ArrayList<>();
		String replaceAll;
		for (WebElement price : carlist) {
			String text = price.getText();
			replaceAll = text.replaceAll("\\D", "");
			System.out.println(replaceAll);
		
			list.add(Integer.parseInt(replaceAll));
			

		}

		Collections.sort(list);
		System.out.println("min"+list.get(0));
		System.out.println("max"+list.get(list.size()-1));
		System.out.println("a");
		
		
Integer max = Collections.max(list);
System.out.println(max);
		
		
		 
		 Integer integer = list.get(list.size()-1);
		 
		 WebElement brandname = locateElement("xpath","//*[contains(text(),'"+integer.toString()+"')]/preceding::h3[1]");
		
		 System.out.println(brandname);
		
		driver.quit();


	}
}