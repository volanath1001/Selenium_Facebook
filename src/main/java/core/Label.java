package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Label extends Base{
	String el = null;
	public Label(String el) {
		this.el = el;
	}
	
	
	public void isDisplayed(){
		WebElement e = element();
		Assert.assertTrue(e.isDisplayed());
	}
	public void clear(){
		WebElement e = element();
		e.clear();
	}
	public void click(){
		WebElement e = element();
		e.click();
	}
	public void populate(String key){
		WebElement e = element();
		e.sendKeys(key);
	}
	

	public WebElement  element(){

		String type = el.substring(0, el.indexOf("="));
		String key = el.substring(el.indexOf("=")+1);
		WebElement e =null;
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
