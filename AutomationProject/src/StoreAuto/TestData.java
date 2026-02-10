package StoreAuto;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TestData
{
	String MyWebSite = "https://automationteststore.com/";

	WebDriver driver = new EdgeDriver();
	Random rand = new Random();
	String PasswordAndConfirmPassword = "Asd123!@#";

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
	
	int randomEmailNumber1 = rand.nextInt(5897);
	int randomEmailNumber2 = rand.nextInt(532);
	
	String TheEmail = randomFirstName + randomLastName + randomEmailNumber1 + randomEmailNumber2 + "@gamil.com";
	
	int randCountry=rand.nextInt(1,20);
	
	public void SetupMyTest()
	{
		driver.get(MyWebSite);
		driver.manage().window().maximize();
	}
	
	String logout ="https://automationteststore.com/index.php?rt=account/logout";
	String expectedLogoutMessage ="You have been logged off your account.";
	boolean ExpectedLogoutValue = true ; 
	
	String LoginInfo=randomFirstName + randomLastName + randomEmailNumber1 + randomEmailNumber2;
	

}
