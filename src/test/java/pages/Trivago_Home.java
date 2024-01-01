package pages;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Trivago_Home {

	WebDriver driver;
	
	By trivago_logo=By.xpath("//*[@id=\"__next\"]/div[1]/div[1]/div[1]/div[2]/header/a");  //Logo locator
	
	By trivago_language=By.xpath("//*[@id=\"__next\"]/div[1]/div[1]/div[1]/div[2]/header/nav/ul/li[2]/button/span[2]/span");  //Language locator
	By language_sel=By.xpath("//*[@id=\"language-select\"]");  //Language selector locator
	By langauge_currency=By.xpath("//*[@id=\"currency-select\"]");  //Currency locator
	By langauge_apply=By.xpath("/html/body/section[1]/dialog/div/div/form/div[3]/button"); //Apply button locator
	
	By login=By.xpath("//*[@id=\"__next\"]/div[1]/div[1]/div[1]/div[2]/header/nav/ul/li[3]/div/button/span[2]/span");  //Login link locator
	By trivago_policy=By.xpath("//*[@id=\"privacyPolicy\"]");  //Privacy policy link locator
	By trivago_terms=By.xpath("//*[@id=\"termsOfService\"]");  //Terms of use link locator
	By login_email=By.xpath("//*[@id=\"email\"]");  //Login/Sign up email locator
	By login_next_button=By.xpath("//*[@id=\"__next\"]/section/div/div/main/div/form/button");  //username next locator
	By login_password=By.xpath("//*[@id=\"password\"]");  //Login/sign up password locator
	By login_create_account=By.xpath("//*[@id=\"__next\"]/section/div/div/main/div/form/button");  //Create account button locator
	
	By trivago_account=By.xpath("//*[@id=\"__next\"]/div[1]/div[1]/div[1]/div[2]/header/nav/ul/li[3]");  //Account menu locator
	By ac_settings=By.xpath("//*[@id=\"__next\"]/div[1]/div[1]/div[1]/div[2]/header/nav/ul/li[3]/div/div/div/div/nav/ul/li[1]/a/span/span");  //Account settings locator
	By ac_fname=By.xpath("//*[@id=\"input-3\"]");  //First name locator
	By ac_lname=By.xpath("//*[@id=\"input-4\"]");  //Last name locator
	By ac_Update=By.xpath("//*[@id=\"__next\"]/div[2]/div[3]/section/article/section[1]/form/div[3]/button[1]");  //Update button locator
	By ac_recently_viewed=By.xpath("//*[@id=\"__next\"]/div[2]/div[3]/section/nav/ul/li[2]/a");  //recently viewed locator
	By ac_help=By.xpath("//*[@id=\"__next\"]/div[2]/div[3]/section/nav/ul/li[3]/a");  //Help and support locator
	By help_topic=By.xpath("//*[@id=\"select-article\"]");  //Select a topic drop down locator
	
	By trivago_home=By.xpath("//*[@id=\"__next\"]/div[2]/div[2]/div/header/a");  //Back to home page locator
	
	By search_landmark=By.xpath("//*[@id=\"input-auto-complete\"]");  //Landmark locator
	By checkin_date=By.xpath("//*[@id=\"__next\"]/div[1]/div[1]/section/div[2]/div[4]/div/div[1]/fieldset/button[1]/span/span[2]/span[1]");  //Check in date locator
	By default_date=By.xpath("//*[@id=\"__next\"]/div[1]/div[1]/section/div[2]/div[4]/div/div[2]/div/div/div/div[2]/div/div[1]/h3");  //Default month and year locator
	By date_next=By.xpath("//*[@id=\"__next\"]/div[1]/div[1]/section/div[2]/div[4]/div/div[2]/div/div/div/div[2]/button[2]");  //Date next button locator
	By all_dates=By.xpath("//*[@id=\"__next\"]/div[1]/div[1]/section/div[2]/div[4]/div/div[2]/div/div/div/div[2]/div/div[1]/div[2]/button/time");  //All dates locator
	By adults=By.xpath("//*[@id=\"number-input10\"]");  //Adults input locator
	By children=By.xpath("//*[@id=\"number-input11\"]");  //Children input locator
	By rooms=By.xpath("//*[@id=\"number-input12\"]");  //Rooms input locator
	By pet_friendly_checkbox=By.xpath("//*[@id=\"checkbox-13\"]");  //Pet friendly check box locator
	By search_apply=By.xpath("//*[@id=\"__next\"]/div[1]/div[1]/section/div[2]/div[4]/div/div[2]/div/div/div[2]/div/button[2]"); //Guest and rooms apply button locator
	
	
	//Filter
	By price_per_night=By.xpath("//*[@id=\"__next\"]/div[1]/main/div[2]/div[2]/div/div/div/div[1]/div/button");  //Price per night button locator
	By max_price=By.xpath("//*[@id=\"__next\"]/div/main/div[2]/div[2]/div/div/div/div[1]/div/div/div/div[2]/section/div/section/section/div[2]/div[2]/div/input");  //Max price input locator	By filters=By.xpath("//*[@id=\"__next\"]/div[1]/main/div[2]/div[2]/div/div/div/div[2]/div/button"); //Filters button locator
	By sort_by=By.xpath("//*[@id=\"sorting-selector\"]");  //Sort y select tag locator
	By disable_map=By.xpath("//*[@id=\"__next\"]/div/main/div[3]/div[2]/div/div/div[1]/div/button");  //Map disable button locator
	
	By footer=By.xpath("//*[@id=\"__next\"]/div[2]/div/footer"); //Footer section locator
	
	public Trivago_Home(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	//Validating logo
	public void logo_Validate()
	{
		Boolean logo=driver.findElement(trivago_logo).isDisplayed();

		
		if(logo)
		{
			System.out.println("Logo Present");
		}
		else
		{
			System.out.println("Logo is not present");
		}
	}
	
	// Language link
	public void language() throws Exception
	{
		driver.findElement(trivago_language).click();
		
		WebElement lang= driver.findElement(language_sel);
		Select sel1=new Select(lang);
		sel1.selectByVisibleText("English");
		
		WebElement currency=driver.findElement(langauge_currency);
		Select sel2=new Select(currency);
		sel2.selectByValue("INR");
		
		
		driver.findElement(langauge_apply).click();
		
	}
	
	
	//Login 
	public void login_click()
	{
		driver.findElement(login).click();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	//Privacy policy and terms of use
	public void privacy_terms() throws Exception
	{
		driver.findElement(trivago_policy).click();
		
		String parent_window=driver.getWindowHandle();
		
		Set<String> allwindow=driver.getWindowHandles();
		
		for(String windowhandle:allwindow)
		{
			if(!windowhandle.equalsIgnoreCase(parent_window))
			{
				driver.switchTo().window(windowhandle);
				System.out.println("Window title : "+driver.getTitle());

				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
				Thread.sleep(1000);
				driver.close();
			}
		}
		driver.switchTo().window(parent_window);
		
		driver.findElement(trivago_terms).click();
		Set<String> allwindow1=driver.getWindowHandles();

		for(String windowhandle:allwindow1)
			
		{
			if(!windowhandle.equalsIgnoreCase(parent_window))
			{
				driver.switchTo().window(windowhandle);
				System.out.println("Window title : "+driver.getTitle());

				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
				Thread.sleep(1000);
				driver.close();
			}
		}
		driver.switchTo().window(parent_window);
				
	}
	
	//Login/Sign up 
	public void signup()
	{
		driver.findElement(login_email).sendKeys("sample1@gmail.com");
		
		driver.findElement(login_next_button).click();
		
		
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(login_password));
		driver.findElement(login_password).click();
		driver.findElement(login_password).sendKeys("Samplesample123+");
		driver.findElement(login_create_account).click();
	}
	
	
	public void account() throws Exception
	{		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(trivago_account));
		
		WebElement ac_menu=driver.findElement(trivago_account);
		Actions act=new Actions(driver);	
		act.moveToElement(ac_menu).perform();
		ac_menu.click();
		
		WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(ac_settings)).click();
		
		Thread.sleep(2000);
		
		
		driver.findElement(ac_fname).clear();
		driver.findElement(ac_fname).sendKeys("John");
		driver.findElement(ac_lname).clear();
		driver.findElement(ac_lname).sendKeys("doe");
		driver.findElement(ac_Update).click();
		
		
		driver.findElement(ac_help).click();
		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(help_topic));
		WebElement topic=driver.findElement(help_topic);
		Select sel=new Select(topic);
		sel.selectByIndex(2);
		Thread.sleep(1000);
		
		driver.findElement(ac_recently_viewed).click();
		
		driver.findElement(trivago_home).click();
	}
	
	
	public void booking() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(search_landmark));
		
		WebElement landmark= driver.findElement(search_landmark);
		landmark.click();
		landmark.sendKeys("Bengaluru",Keys.ENTER);
		
		driver.findElement(checkin_date).click();
		
		WebElement def_date=driver.findElement(default_date);
		String month=def_date.getText();
		
		while(true)
		{
			if(month.equalsIgnoreCase("February 2024"))
			{
				System.out.println("Month and year : "+month);
				break;
			}
			else
			{
				driver.findElement(date_next).click();
				break;
			}
		}
		
		
		List<WebElement> alldates = driver.findElements(all_dates);
		
		//Check in date selecting
		for(WebElement checkin_date:alldates)
		{
			String current_date=checkin_date.getText();
			
			if(current_date.equals("8"))
			{
				System.out.println("Selected checkin date : "+current_date);
				checkin_date.click();
				break;
			}
		}
		

		
		//Check out date selecting
		
		List<WebElement> alldates1 = driver.findElements(all_dates);
		
		for(WebElement checkout_date:alldates1)
		{
			String current_date=checkout_date.getText();
			
			if(current_date.equals("9"))
			{
				System.out.println("Selected checkout date : "+current_date);
				checkout_date.click();
				break;
			}
		}

	}

	public void guests_rooms() throws Exception
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement ad=driver.findElement(adults);
		ad.sendKeys(Keys.BACK_SPACE);
		ad.sendKeys("3");


		
		WebElement ch=driver.findElement(children);
		ch.sendKeys(Keys.BACK_SPACE);		
		ch.sendKeys("2");
		
		WebElement rm=driver.findElement(rooms);
		rm.sendKeys(Keys.BACK_SPACE);
		rm.sendKeys("1");
		
		driver.findElement(pet_friendly_checkbox).click();
		
		Thread.sleep(6000);
		
		driver.findElement(search_apply).click();
		
		
	}
	
	public void filter_sort() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(price_per_night));
		
		WebElement price_filter=driver.findElement(price_per_night);
		
		Actions act=new Actions(driver);
		act.moveToElement(price_filter).perform();
		
		WebElement max= driver.findElement(max_price);
		max.sendKeys(Keys.BACK_SPACE);
		max.sendKeys("12000");
		
		WebElement sort=driver.findElement(sort_by);
		Select sel=new Select(sort);
		sel.selectByIndex(3);
		
		driver.findElement(disable_map).click();

		Thread.sleep(2000);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println("Scrolled");
				
	}
	
	
	public void footer() throws Exception
	{
		WebElement footer1=driver.findElement(footer);
		
		List<WebElement> links = footer1.findElements(By.tagName("a"));
		
		
		System.out.println("Total links : "+links.size());
		
		for(WebElement a:links)
		{
			a.click();
			Thread.sleep(2000);
			String link=a.getAttribute("href");
			String link_text=a.getText();
			System.out.println(link_text+" : "+link);
			
			String parent_window=driver.getWindowHandle();
			Set<String> allwindow = driver.getWindowHandles();
			
			for(String window:allwindow)
			{
				
				if(!parent_window.equalsIgnoreCase(window))
				{
					driver.switchTo().window(window);
					driver.close();
				}
			}
			driver.switchTo().window(parent_window);
		}
	}
	
	
	
}