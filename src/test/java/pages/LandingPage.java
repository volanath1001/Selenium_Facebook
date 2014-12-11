package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import screenObject.LandingPageScreen.LandingPageWidget;
import core.Base;

public class LandingPage extends Base{

	public Messages messages() {
		driver.findElement(LandingPageWidget.messagesLink).click();
		return new Messages(driver);
	}
	public Photos photos() {
		driver.findElement(LandingPageWidget.photo).click();
		return new Photos(driver);
	}
	
}
