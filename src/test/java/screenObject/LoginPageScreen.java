package screenObject;

import helper.Excel;

import org.openqa.selenium.By;

import util.Widgets;
import core.TextBox;


public class LoginPageScreen {

	
	public static class LoginPageWidget {
		
		public static TextBox user= new TextBox("id=email"); 
		public static TextBox pass= new TextBox("id=pass"); 
		public static By pass_Xpath= By.xpath("//*[@id='pass']"); 

		
		
		
	}
}
