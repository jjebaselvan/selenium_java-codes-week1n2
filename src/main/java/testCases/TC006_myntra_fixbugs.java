package testCases;




	import java.util.ArrayList;

	import java.util.Collections;
	import java.util.List;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.testng.annotations.Test;

	
	public class TC006_myntra_fixbugs {
		
		public static void main(String[] args) throws InterruptedException {
			
			

			// launch the browser
			System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();
			driver.get("https://www.myntra.com/");
			
		

			// Mouse Over on Men
			Actions builder = new Actions(driver);
			builder.moveToElement(driver.findElementByLinkText("Men")).perform();

			// Click on Jackets
			driver.findElementByXPath("//a[@href='/men-jackets']").click();


			// Find the count of Jackets
			String leftCount = 
					driver.findElementByXPath("//span[@class='horizontal-filters-sub']")
					.getText()
					.replaceAll("//D", "");
			System.out.println(leftCount);

			Thread.sleep(5000);
			
			// Click on Jackets and confirm the count is same
			driver.findElementByXPath("//label[text()='Jackets']").click();

			// Wait for some time
			Thread.sleep(5000);

			// Check the count
			String rightCount = 
					driver.findElementByXPath("//span[@class='horizontal-filters-sub']")
					.getText()
					.replaceAll("//D", "");
			System.out.println(rightCount);

			// If both count matches, say success
			if(leftCount.equals(rightCount)) {
				System.out.println("The count matches on either case");
			}else {
				System.err.println("The count does not match");
			}

			// Click on Offers
			driver.findElementByXPath("//h4[text()='Offers']").click();

			// Find the costliest Jacket
			List<WebElement> productsPrice = driver.findElementsByXPath("//span[@class='product-discountedPrice']");
			List<String> onlyPrice = new ArrayList<String>();

			for (WebElement maxprice : productsPrice) {
				onlyPrice.add(maxprice.getText().replaceAll("\\D", ""));
				
			}

			System.out.println("list contents are    "+onlyPrice);
		
			
			
			// Sort them 
			String jacketsmaxprice = Collections.max(onlyPrice);

			// Find the top one
			System.out.println("maxxxx is "+jacketsmaxprice);
			
			

			// Print Only Allen Solly Brand Minimum Price
			driver.findElementByXPath("//div[@class = 'brand-more']").click();
			driver.findElementByXPath("(//label[contains(@class,'common-customCheckbox')])[12]").click();
			driver.findElementByXPath("(//span[contains(@class,'myntraweb-sprite')])[5]").click();

			Thread.sleep(5000);
			
			// Find the costliest Jacket
			List<WebElement> allenSollyPrices = driver.findElementsByXPath("//span[@class='product-discountedPrice']");
			
			List<String> allensollylist = new ArrayList<String>();


			System.out.println("allen solly list contents before replacing are  "+ allensollylist);
			

			for (WebElement minprice : allenSollyPrices) {
				allensollylist.add(minprice.getText().replaceAll("//D", ""));
			}

			
			System.out.println("allen solly list contents are  "+ allensollylist);
			
			// Get the minimum Price 
			String min = Collections.min(allensollylist);

			// Find the lowest priced Allen Solly
			System.out.println(min);
			
			driver.close();

		}

	}


