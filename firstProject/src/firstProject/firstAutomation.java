package firstProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class firstAutomation {

	WebDriver driver = new ChromeDriver();
	
	@BeforeTest
	public void myFirstTest() {
		driver.get("https://smartbuy-me.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void myTest() {
		driver.findElement(By.className("search-bar__input")).sendKeys("Iphone");
		driver.findElement(By.className("search-bar__submit")).click();
	}
	

}
