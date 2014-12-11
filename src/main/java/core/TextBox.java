package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TextBox extends Base{
	
	String element = null;
	
	public TextBox(String element) {
		this.element = element;
	}
	public void populate(String value){
		logger.info(value);
		element().sendKeys(value);
	}
	
	
	public WebElement element(){
		String type = element.substring(0, element.indexOf("="));
		String key = element.substring(element.indexOf("=")+1);
		WebElement e = null;
		switch (type) {
		case "xpath":
			e = driver.findElement(By.xpath(key));
			break;
		case "name":
			e = driver.findElement(By.name(key));
			break;
		case "id":
			e = driver.findElement(By.id(key));
			break;
		case "linkText":
			e = driver.findElement(By.linkText(key));
			break;
		case "className":
			e = driver.findElement(By.className(key));
			break;
		case "cssSelector":
			e = driver.findElement(By.cssSelector(key));
			break;
		case "partialLinkText":
			e = driver.findElement(By.partialLinkText(key));
			break;
		case "tagName":
			e = driver.findElement(By.tagName(key));
			break;
		default:
			break;
		}
		return e;
	}
	

}
