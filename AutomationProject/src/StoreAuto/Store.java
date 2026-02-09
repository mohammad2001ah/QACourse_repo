package StoreAuto;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import net.bytebuddy.dynamic.DynamicType.Builder.InnerTypeDefinition;

public class Store
{
	String MyWebSite = "https://automationteststore.com/";

	WebDriver driver = new EdgeDriver();
	Random rand = new Random();
	String PasswordAndConfirmPassword = "Asd123!@#";


	@BeforeTest
	public void MySetup()
	{
		driver.get(MyWebSite);
		driver.manage().window().maximize();
	}

	/**
	 * @throws InterruptedException
	 */
	@Test(priority = 1)
	public void SignUPTest() throws InterruptedException
	{

		/*
		 * partial >>>> tack part of text LinkText >>> tack all text and it is best than
		 * partial just in <a> tag
		 */
		// driver.findElement(By.partialLinkText("Login or")).click();
		WebElement loginAndSignUpButton = driver.findElement(By.linkText("Login or register"));
		loginAndSignUpButton.click();

		// xpath syntax >> //tagname[@ attribute='']

		driver.findElement(By.xpath("//button[@title='Continue']")).click();
		String[] femaleNames =
		{ "Noor", "Layan", "Reem", "Sara", "Maryam", "Tala", "Joud", "Haya", "Rana", "Dana" };
		String[] maleNames =
		{ "Ahmad", "Mohammad", "Omar", "Ali", "Yousef", "Khaled", "Hamza", "Bilal", "Zaid", "Hassan" };
		String[] jordanAddresses =
		{ "Amman - Abdoun Street", "Irbid - University Street", "Zarqa - King Hussein Street", "Aqaba - Corniche Road",
				"Salt - Main Square", "Madaba - City Center", "Jerash - Roman Street", "Karak - Castle Road",
				"Mafraq - Downtown", "Tafilah - Main Road" };

		int randomindex1 = rand.nextInt(femaleNames.length);
		int randomindex2 = rand.nextInt(maleNames.length);
		int randomIndex3=rand.nextInt(jordanAddresses.length);

		String randomFirstName = femaleNames[randomindex1];
		String randomLastName = maleNames[randomindex2];
		String randomAddressName = jordanAddresses[randomIndex3];
		WebElement FirstNameInput = driver.findElement(By.id("AccountFrm_firstname"));
		FirstNameInput.sendKeys(randomFirstName);

		WebElement lastNameInput = driver.findElement(By.id("AccountFrm_lastname"));
		lastNameInput.sendKeys(randomLastName);

		int randomEmailNumber1 = rand.nextInt(5897);
		int randomEmailNumber2 = rand.nextInt(532);

		String TheEmail = randomFirstName + randomLastName + randomEmailNumber1 + randomEmailNumber2 + "@gamil.com";
		WebElement EmailInput = driver.findElement(By.id("AccountFrm_email"));
		EmailInput.sendKeys(TheEmail);
		
		WebElement address1=driver.findElement(By.id("AccountFrm_address_1"));
		address1.sendKeys(randomAddressName);
		
		WebElement cityElement=driver.findElement(By.id("AccountFrm_city"));
		cityElement.sendKeys("Amman");
		
		WebElement CountryDropDwon=driver.findElement(By.id("AccountFrm_country_id"));
		Select CountrySelect=new Select(CountryDropDwon);
		int randCountry=rand.nextInt(1,20);
		CountrySelect.selectByVisibleText("Jordan");
		Thread.sleep(10000);
		
		WebElement StateDropDown= driver.findElement(By.id("AccountFrm_zone_id"));
		int randState=rand.nextInt(StateDropDown.findElements(By.tagName("option")).size());
		Select SelectforStateDropDown = new Select(StateDropDown);
		SelectforStateDropDown.selectByIndex(randState);
		
		WebElement PostalInput = driver.findElement(By.id("AccountFrm_postcode"));
		PostalInput.sendKeys("randomPostal");
		
		WebElement LoginNameInput = driver.findElement(By.id("AccountFrm_loginname"));
		LoginNameInput.sendKeys(randomFirstName + randomLastName + randomEmailNumber1 + randomEmailNumber2);
		
		WebElement PasswordInput = driver.findElement(By.id("AccountFrm_password"));
		WebElement ConfirmPasswordInput = driver.findElement(By.id("AccountFrm_confirm"));

		PasswordInput.sendKeys(PasswordAndConfirmPassword);
		ConfirmPasswordInput.sendKeys(PasswordAndConfirmPassword);
		
		WebElement ConditionsAndTermsCheckbox =driver.findElement(By.id("AccountFrm_newsletter1"));
		ConditionsAndTermsCheckbox.click();
		
		WebElement checkBoxElement= driver.findElement(By.id("AccountFrm_agree"));
		checkBoxElement.click();
		
		WebElement Continue =driver.findElement(By.cssSelector(".btn.btn-orange.pull-right.lock-on-click"));
		Continue.click();
		
		Assert.assertEquals(driver.getCurrentUrl().contains("success"), true);
		Assert.assertEquals(driver.getPageSource().contains("Congratulations"), true);
		
		WebElement WelcomeMessageArea = driver.findElement(By.id("customernav"));

		Assert.assertEquals(WelcomeMessageArea.getText().contains(randomFirstName), true);





		
		

	}

}
