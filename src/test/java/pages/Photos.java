package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Photos {
	
WebDriver driver = null;
	
	public Photos(WebDriver driver) {
		this.driver = driver;
	}
	
	public void changePic() throws InterruptedException{
		driver.findElement(By.xpath("(//img[@src='https://fbstatic-a.akamaihd.net/rsrc.php/v2/yx/r/PuyR8Oy6W1C.png'])[2]")).click();
		driver.findElement(By.name("photo")).sendKeys("C:\\Users/ghosh\\Pictures\\shiva.jpg");

		System.out.println("Waiting");
		Thread.sleep(5000);
	}

}
