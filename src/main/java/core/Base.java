package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {
	
	public static WebDriver driver = null;
	public Properties properties = null;
	public static Logger logger = LogManager.getLogger();
	public static Logger log =LogManager.getLogger(Base.class.getName());
	
	
	
	@BeforeMethod
	public void start(){
		log.debug("Start");
		//if(driver==null){
			properties = new Properties();
			try {
				InputStream inputStream = new FileInputStream(
						new File(System.getProperty("user.dir")+"/src/test/resources/config/config.properties"));
				try {
					properties.load(inputStream);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			
			}
			
			// If you want to change  browser in Properties file then pass "bName" variable into switch contractor 
			String bName = properties.getProperty("browser");
			
			// If you want to change  browser in command prompt  then pass "bName" variable into switch contractor 
			String browserName = System.getProperty("browser");
			
			
			// NOTE : If you do not use command prompt then only use "bName in to SWITCH contractor"
			switch (bName) {
			case "firefox":
				logger.info(Constant.dash);
				logger.info("Starting Firefox browser");
				logger.info(Constant.dash);
				driver = new FirefoxDriver();
				break;
			case "chrome":
				logger.info(Constant.dash);
				logger.info("Starting Chrome browser");
				logger.info(Constant.dash);
				//Set Chrome Driver path to execute test cases
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/driver/chromedriver.exe");
				driver = new ChromeDriver();
				break;
			case "IE":
				logger.info(Constant.dash);
				logger.info("Starting Internet Explorer browser");
				logger.info(Constant.dash);
				
				//Set Internet Explorer Driver path to execute test cases
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+
						"/src/test/resources/driver/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				break;
			case "htmlUnit":
				logger.info("Starting Htma Unit browser");
				driver = new HtmlUnitDriver();
				break;
			case "safari":
				logger.info(Constant.dash);
				logger.info("Starting safari browser");
				logger.info(Constant.dash);
				driver = new SafariDriver();
				break;
			default:
				// Default browser 
				logger.info(Constant.dash);
				logger.info("Starting default browser");
				logger.info(Constant.dash);
				driver = new FirefoxDriver();
				break;
			}
		//}
		
		// Delete all cookies from browser
		driver.manage().deleteAllCookies();
		
		// Navigate to the test URL
		
		// NOTE : If you want to pass test url in commend prompt then pass "cURL" variable in get contractor.
					
		
		String URL = Constant.URL;
		String cURL = Constant.cURL;
		
		driver.get(URL);
		
		// Set global wait time for find the page element 
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		
	}
	@AfterMethod
	public void close(){
		
		// Close the browser end of the test
		driver.quit();
	}
	private final static SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd.HH.mm.ss");
	public void captureScreenShotToFile(String methodName) throws IOException{
		
		File browserFile = new File(System.getProperty("user.dir")+"\\screenShort\\"+methodName+"_"+getCurrentTimeStamp()+".png");
		
		if(driver == null){
		}
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		FileUtils.copyFile(scrFile, browserFile);
	}

	public static String getCurrentTimeStamp() {        
	    Calendar cal = Calendar.getInstance();
	    String strDate = sdfDate.format(cal.getTime());
	    System.out.println();
	    return strDate;
	}
	
	public void Label() {



	}
	
	public void element(String element){
		
		switch (element.substring(0, element.indexOf("="))) {
		case "xpath":
			driver.findElement(By.xpath(element)).click();
			break;
		case "name":
			driver.findElement(By.name(element)).click();
			break;
		case "id":
			driver.findElement(By.id(element)).click();
			break;
		case "linkText":
			driver.findElement(By.linkText(element)).click();
			break;
		case "className":
			driver.findElement(By.className(element)).click();
			break;
		case "cssSelector":
			driver.findElement(By.cssSelector(element)).click();
			break;
		case "partialLinkText":
			driver.findElement(By.partialLinkText(element)).click();
			break;
		case "tagName":
			driver.findElement(By.tagName(element)).click();
			break;
		default:
			
			break;
		}
		
	}
	public void click(By by){
		
		driver.findElement(by).click();
		
	}
}
