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

public class Store extends TestData
{
	@BeforeTest
	public void MySetup()
	{
		SetupMyTest();
	}

	@Test(priority = 1, invocationCount = 10)
	public void SignUPTest() throws InterruptedException
	{
		// --------------Web Elements-------------------------------------//
		WebElement loginAndSignUpButton = driver.findElement(By.linkText("Login or register"));
		loginAndSignUpButton.click();
		WebElement ContinueButtonBeforeSignUp = driver.findElement(By.xpath("//button[@title='Continue']"));
		ContinueButtonBeforeSignUp.click();
		WebElement FirstNameInput = driver.findElement(By.id("AccountFrm_firstname"));
		WebElement lastNameInput = driver.findElement(By.id("AccountFrm_lastname"));
		WebElement EmailInput = driver.findElement(By.id("AccountFrm_email"));
		WebElement address1 = driver.findElement(By.id("AccountFrm_address_1"));
		WebElement cityElement = driver.findElement(By.id("AccountFrm_city"));
		WebElement CountryDropDwon = driver.findElement(By.id("AccountFrm_country_id"));
		Thread.sleep(2000);
		WebElement StateDropDown = driver.findElement(By.id("AccountFrm_zone_id"));
		WebElement PostalInput = driver.findElement(By.id("AccountFrm_postcode"));
		WebElement LoginNameInput = driver.findElement(By.id("AccountFrm_loginname"));
		WebElement PasswordInput = driver.findElement(By.id("AccountFrm_password"));
		WebElement ConfirmPasswordInput = driver.findElement(By.id("AccountFrm_confirm"));
		WebElement ConditionsAndTermsCheckbox = driver.findElement(By.id("AccountFrm_newsletter1"));
		WebElement checkBoxElement = driver.findElement(By.id("AccountFrm_agree"));
		WebElement Continue = driver.findElement(By.cssSelector(".btn.btn-orange.pull-right.lock-on-click"));
		WebElement WelcomeMessageArea = driver.findElement(By.id("customernav"));

		// --------------------Action Area--------------------

		FirstNameInput.sendKeys(randomFirstName);
		lastNameInput.sendKeys(randomLastName);
		EmailInput.sendKeys(TheEmail);
		address1.sendKeys(randomAddressName);
		cityElement.sendKeys("Amman");
		Select CountrySelect = new Select(CountryDropDwon);
		CountrySelect.selectByVisibleText("Jordan");
		Thread.sleep(5000);
		int randState = rand.nextInt(StateDropDown.findElements(By.tagName("option")).size());
		Select SelectforStateDropDown = new Select(StateDropDown);
		SelectforStateDropDown.selectByIndex(randState);
		PostalInput.sendKeys("randomPostal");
		LoginNameInput.sendKeys(LoginInfo);
		PasswordInput.sendKeys(PasswordAndConfirmPassword);
		ConfirmPasswordInput.sendKeys(PasswordAndConfirmPassword);
		ConditionsAndTermsCheckbox.click();
		checkBoxElement.click();
		Continue.click();

		// -------------------- Assertion--------------------
		Assert.assertEquals(driver.getCurrentUrl().contains("success"), true);
//		Assert.assertEquals(driver.getPageSource().contains("Congratulations"), true);
//		Assert.assertEquals(WelcomeMessageArea.getText().contains(randomFirstName), true);
	}

	@Test(priority = 2, enabled = false)
	public void Logout()
	{
		driver.navigate().to(logout);
		WebElement contentpaneLogoutMessag = driver.findElement(By.className("contentpanel"));
		boolean ActualLogoutValue = contentpaneLogoutMessag.getText().contains(expectedLogoutMessage);

		// Assertion
		Assert.assertEquals(ActualLogoutValue, ExpectedLogoutValue);
	}

	@Test(priority = 3, enabled = false)
	public void Login()
	{
		WebElement loginAndSignUpButton = driver.findElement(By.linkText("Login or register"));
		loginAndSignUpButton.click();
		// Element inside the login form
		WebElement LoginName = driver.findElement(By.id("loginFrm_loginname"));
		WebElement Password = driver.findElement(By.id("loginFrm_password"));

		// Actions
		LoginName.sendKeys(LoginInfo);
		Password.sendKeys(PasswordAndConfirmPassword);
		WebElement LoginButton = driver.findElement(By.xpath("//button[@title='Login']"));
		LoginButton.click();

		// Assertion
		WebElement welcomeMessagElement = driver.findElement(By.id("customernav"));
		Assert.assertEquals(welcomeMessagElement.getText().contains(randomFirstName), true);
	}

	@Test(priority = 4,invocationCount = 10)
	public void AddRandomToCart()
	{
		driver.navigate().to("https://automationteststore.com/");
		int totalItems = driver.findElements(By.className("prdocutname")).size();
		int randomItem = rand.nextInt(totalItems);

		driver.findElements(By.className("prdocutname")).get(randomItem).click();
		if (driver.getCurrentUrl().contains("product_id=116"))
		{
			driver.findElement(By.id("option344747")).click();
		}
		driver.findElement(By.className("productpagecart")).click();
	}

}
