package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Trivago_Home;

public class Trivago_Test {

	WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();

	}
	
	@BeforeMethod
	public void urlloading()
	{
		driver.get("https://www.trivago.in/");
	}
	
	@Test
	public void test() throws Exception
	{
		Trivago_Home ob=new Trivago_Home(driver);
		
		ob.logo_Validate();
		ob.language();
		ob.login_click();
		ob.privacy_terms();
		ob.signup();
		ob.account();
		ob.booking();
		ob.guests_rooms();
		ob.filter_sort();
		ob.footer();
		
	}
	
	
}

