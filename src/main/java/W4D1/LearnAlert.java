package W4D1;


	
	import org.openqa.selenium.chrome.ChromeDriver;

	public class LearnAlert {

		public static void main(String[] args) throws InterruptedException {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.Exe");
			ChromeDriver driver = new ChromeDriver();
			driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
			driver.switchTo().frame("iframeResult");
			driver.findElementByXPath("//button[text()='Try it']").click();
			Thread.sleep(5000);
			driver.switchTo().alert().sendKeys("Sheeba");
			Thread.sleep(5000);
			driver.switchTo().alert().accept();
			Thread.sleep(5000);
			String text = driver.findElementById("demo").getText();
			System.out.println(text);
			driver.switchTo().defaultContent();
					
			// 2nd frame
			
			driver.switchTo().frame("google_ads_iframe_/16833175/TryitLeaderboard_0");
			driver.findElementById("cbb").click();
			Thread.sleep(5000);
			driver.switchTo().defaultContent();
			Thread.sleep(5000);
			driver.findElementById("tryhome").click();
			
			// accepting alert
			driver.switchTo().alert().accept();

		}

	}


