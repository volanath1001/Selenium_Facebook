package screenObject;

import org.openqa.selenium.By;

import core.Label;
import core.TextBox;

public class LandingPageScreen {
	
	public static class LandingPageWidget{
		
		
		public static By messagesLink = By.xpath("(//span[contains(.,'Messages')])[2]");
		public static By photo = By.xpath("//div/span[text()='Photos']");
		public static Label useNameDis = new Label("xpath=//*[@id='blueBarNAXAnchor']/div[1]/div/div/div[1]/ul/li[1]/a/span");

	}

}
