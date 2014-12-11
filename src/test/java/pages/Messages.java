package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Messages {
	
	WebDriver driver = null;
	
	public Messages(WebDriver driver) {
		this.driver = driver;
	}
	
	public void sendMessages(){
		
		driver.findElement(By.xpath("//div/button/img")).click();
		driver.findElement(By.xpath("//input[@aria-label='Name']")).sendKeys("Kamolesh Bachar");
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div[2]/div[2]/div[1]/div/div/div/div[3]/div/div[4]/div[2]/div[1]/div[2]/div/div/div[2]/div/div[1]/div/ul/li[2]/div/a/div/div[2]/div/span")).click();
	
		driver.findElement(By.name("message_body")).sendKeys(" W");
		driver.findElement(By.id("u_jsonp_2_b")).click();

		
	
	}
	
	
	
	

}
