package pages;

import java.io.IOException;

import helper.Excel;
import helper.XML;

import org.jdom2.JDOMException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import screenObject.LandingPageScreen.LandingPageWidget;
import screenObject.LoginPageScreen;
import screenObject.LoginPageScreen.LoginPageWidget;
import core.Base;

public class LogInPage extends Base{
	
	LoginPageScreen loginPageScreen = new LoginPageScreen();
	Excel excel=new Excel();
	
	public LandingPage doLogIn(){
		//XML.autoPopulate("loginInfo", loginPageScreen);
		String s[] = excel.getExcelData();
		
		LoginPageWidget.user.populate(s[0]);
		LoginPageWidget.pass.populate(s[1]);
		driver.findElement(LoginPageWidget.pass_Xpath).submit();

		LandingPageWidget.useNameDis.isDisplayed();
		return new LandingPage();
	}
	public void signUp() {


	}
	

}
