package testCases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import framework.SeMethods;

@Test
public class TC004_framedragndrop extends SeMethods {
	
	public void frames() {
		
		startApp("chrome", "https://jqueryui.com/draggable/");
		
		WebElement ele = locateElement("class", "demo-frame");
		
		switchToFrame(ele);
		
		
		WebElement drag = locateElement("id", "draggable");
		
		
		dragndrop(drag, 300, 75);
		
	}

	
	
}
