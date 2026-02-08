package StoreAuto;

import java.security.SecureRandom;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Store
{
	String MyWebSite ="https://automationteststore.com/";
	
	WebDriver driver =new EdgeDriver();
	Random rand =new Random();
	
	@BeforeTest
	public void MySetup() {
		driver.get(MyWebSite);
		driver.manage().window().maximize();
	}
	
	@Test(priority = 1,invocationCount = 6)
	public void SignUPTest() {
		
		/*
		 * partial >>>> tack part of text
		 * LinkText >>> tack all text and it is best than partial
		 * just in <a> tag
		 */
		//driver.findElement(By.partialLinkText("Login or")).click();
		WebElement loginAndSignUpButton=driver.findElement(By.linkText("Login or register"));
		loginAndSignUpButton.click();
		
		// xpath syntax >> //tagname[@ attribute='']
		
		driver.findElement(By.xpath("//button[@title='Continue']")).click();
		String[] femaleNames = {
			    "Noor",
			    "Layan",
			    "Reem",
			    "Sara",
			    "Maryam",
			    "Tala",
			    "Joud",
			    "Haya",
			    "Rana",
			    "Dana"
			};
		int randomindex= rand.nextInt(femaleNames.length);
		
		String randomFirstName = femaleNames[randomindex];
		driver.findElement(By.id("AccountFrm_firstname")).sendKeys(randomFirstName);
		

		
	}


}
