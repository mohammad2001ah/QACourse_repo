package firstProject;


import java.io.StringReader;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePage {
	String MyWebSite = "https://smartbuy-me.com/ar";
	String MyWebSite2 = "https://www.saucedemo.com/";
	String UserName = "";
	String Password = "";

	WebDriver driver = new EdgeDriver();

	// annotation @
	@BeforeTest
	public void MyTest() throws InterruptedException {
		driver.get(MyWebSite2);
		driver.manage().window().maximize();
		// driver.manage().window().minimize();
		// driver.manage().window().fullscreen();

		// driver.navigate().refresh();
		Thread.sleep(3000);
		// driver.navigate().refresh();
		// driver.navigate().refresh();
		/*
		 * first open first web site then we go to second web site finally we
		 * will back to first web site
		 */
		// driver.navigate().to(MyWebSite2);
		// Thread.sleep(3000);
		// driver.navigate().back();
		// Thread.sleep(3000);
		// driver.navigate().forward();
	}

	@Test(priority = 1)
	public void LoginTest() throws InterruptedException {
		WebElement UserNameInput=driver.findElement(By.id("user-name"));
		WebElement PasswordInput=driver.findElement(By.id("password"));
		WebElement loginButton =driver.findElement(By.id("login-button"));
		UserNameInput.sendKeys("standard_user");
		PasswordInput.sendKeys("secret_sauce");
		Thread.sleep(1000);
		loginButton.click();
	}

	@Test(priority = 2)
	public void AddTest() {
		
	}

}
/**
 * ****Thread.sleep(1000)*******
 *  1-Java wait, not Selenium wait
 *  2-Freezes the test 
 * 	3-Selenium does nothing during this time
 * 
 * *****WebDriverWait*********** 
 * 1-Selenium Explicit Wait
 * 2-Keeps checking
 * 3-Continues immediately once condition is met 
 * 4-If condition is not met
 * selenium throws exception Timeoutexception What happens when WebDriverWait
 * condition is not met? Selenium waits until the timeout expires, then throws a
 * TimeoutException and the test fails.
 */
