package script;

import helper.Excel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import pages.LogInPage;
import core.Base;
import core.Constant;

public class SmokeTest extends Base{
	
	LogInPage logInPage = new LogInPage();
	
	
	@Test
	public void login(){
		Constant.TCID="001";
		
		//XML.setXmlDataFile("data/Smoke.xml");
		Excel.setExcetDataFile("data/Smoke.xlsx");

		logInPage.doLogIn();
		
	}
	
	@Test
	public void t() {
		
		Constant.TCID="005";
		
		//XML.setXmlDataFile("data/Smoke.xml");
		Excel.setExcetDataFile("data/Smoke.xlsx");

		logInPage.doLogIn();
		
	}
	
}
