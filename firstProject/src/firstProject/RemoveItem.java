package firstProject;

import java.awt.desktop.AppHiddenListener;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RemoveItem
{
	String MyWebSite = "https://www.saucedemo.com/";

	WebDriver driver = new EdgeDriver();
	Random rand = new Random();
	
	// annotation @
	@BeforeTest
	public void EnteryPoint()
	{
		driver.get(MyWebSite);
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void LoginTest() throws InterruptedException
	{
		WebElement UserNameInput = driver.findElement(By.id("user-name"));
		WebElement PasswordInput = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login-button"));
		UserNameInput.sendKeys("standard_user");
		PasswordInput.sendKeys("secret_sauce");
		Thread.sleep(1000);
		loginButton.click();
	}

	@Test(priority = 2 , enabled = false)
	public void AddTest()
	{
		List<WebElement> addAllItemToCart = driver.findElements(By.className("btn_primary"));
		List<WebElement> ItemsName = driver.findElements(By.className("inventory_item_name"));

		for (int i = 0; i < addAllItemToCart.size(); i++)
		{
			addAllItemToCart.get(i).click();
		}

		List<WebElement> RemoveButton = driver.findElements(By.className("btn_secondary"));
		for (int i = 0; i < ItemsName.size(); i++)
		{
			RemoveButton.get(i).click();
			System.out.println(ItemsName.get(i).getText() + " " + "Is Removed");
		}
	}
	
	@Test(priority = 2,invocationCount = 3)
	public void AddRandomItem() {
		List<WebElement>addAllItemToCart = driver.findElements(By.className("btn_primary"));
		int randomindex =rand.nextInt(addAllItemToCart.size());
		addAllItemToCart.get(randomindex).click();	
	}

	@AfterTest
	public void after()
	{
		driver.navigate().refresh();
	}
}
