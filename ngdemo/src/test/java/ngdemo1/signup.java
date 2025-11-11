package ngdemo1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class signup {
	public  ChromeDriver driver;

	@BeforeSuite
    public void beforeSuite() {
        System.out.println("🧩 BeforeSuite: Setting up system properties for ChromeDriver");
        io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
    }
	 @BeforeTest
	  public void InitialiseBrowser() {
		 
		  WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
			 driver.manage().window().maximize();
		  System.out.println("browser inistialise ");
	  }
	 

	  @BeforeClass(description="navigating before class")
	  public void beforeClass() throws InterruptedException{
		  System.out.println("Navigating to Website ");
		  driver.navigate().to("https://www.automationexercise.com/login");
			 
	      Thread.sleep(2000);
	      driver.findElement(By.cssSelector("body > div > div.fc-dialog-container > div.fc-dialog.fc-choice-dialog > div.fc-footer-buttons-container > div.fc-footer-buttons > button")).click();
	     
	
		 
	  }

	  
	  
		// 4️⃣ Runs before each @Test method
		    @BeforeMethod
		    public void beforeMethod() {
		        System.out.println("🧩 BeforeMethod: Ready to start a test case");
		    }
		    
	  @Test(priority=1)
	public void makeaccount()throws InterruptedException

	{
		
		WebElement uname=driver.findElement(By.xpath("//input[@placeholder='Name']"));
		uname.sendKeys("navidvcd");
		
		WebElement emm=driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
		emm.sendKeys("nasfsvi@gmail.com");
		
		
		
		WebElement signupbtn=driver.findElement(By.cssSelector("button[data-qa='signup-button']"));
		signupbtn.click();
		Thread.sleep(1000);
		
		WebElement genderselect=driver.findElement(By.id("id_gender2"));
		
		
		// Check if already selected
        if (!genderselect.isSelected()) {
            System.out.println("Radio button is NOT selected, clicking it...");
            genderselect.click();
        } else {
            System.out.println("Radio button is already selected");
        }
        
        // Verify it's selected after clicking
        if (genderselect.isSelected()) {
            System.out.println("✓ Radio button is now selected");
        }
		
		
        WebElement pswd=driver.findElement(By.id("password"));
        pswd.sendKeys("1234567@");
        
        WebElement days=driver.findElement(By.id("days"));
        //days.sendKeys("12");
        Select select = new Select(days);
        WebElement selectedOption = select.getFirstSelectedOption();
        String selectedText = selectedOption.getText();

        System.out.println("Selected option: " + selectedText);
        
        
        WebElement months=driver.findElement(By.id("months"));
       // months.sendKeys("1");
        Select selectm = new Select(months);
        WebElement selectedOptionm = selectm.getFirstSelectedOption();
        String selectedTextm = selectedOptionm.getText();

        System.out.println("Selected option: " + selectedTextm);
        
        WebElement years=driver.findElement(By.id("years"));
       // years.sendKeys("2018");
        Select yearsy = new Select(years);
        
        WebElement selectedOptiony = yearsy.getFirstSelectedOption();
        String selectedTexty = selectedOptiony.getText();

        System.out.println("Selected option: " + selectedTexty);
        
        WebElement checkbox1= driver.findElement(By.id("newsletter"));
        checkbox1.click();
        
        WebElement checkbox2= driver.findElement(By.id("optin"));
        checkbox2.click();
        
        WebElement fname=driver.findElement(By.id("first_name"));
         fname.sendKeys("Manu");
        WebElement lname=driver.findElement(By.id("last_name"));
         lname.sendKeys("kaur");
        WebElement cmpny=driver.findElement(By.id("company"));
        cmpny.sendKeys("network");
        
        
        WebElement adress1=driver.findElement(By.id("address1"));
        adress1.sendKeys("rua alinaca operaia");
        WebElement adress2=driver.findElement(By.id("address2"));
        adress2.sendKeys("alcantara");
        
        
        
        WebElement cuntry=driver.findElement(By.id("country"));
               Select selectcounty = new Select(cuntry);
        WebElement cntry = selectcounty.getFirstSelectedOption();
        String countyr_slected = cntry.getText();
        System.out.println("Selected option: " + countyr_slected);
		Thread.sleep(20);
		
		
		 
        WebElement stt=driver.findElement(By.id("state"));
        stt.sendKeys("lisbon");
        
        WebElement city=driver.findElement(By.id("city"));
        city.sendKeys("alcantraa");
        
        WebElement zipcode=driver.findElement(By.id("zipcode"));
        zipcode.sendKeys("130004");
        
        
        WebElement mb=driver.findElement(By.id("mobile_number"));
        mb.sendKeys("920746388");
        
		WebElement create_account=driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button"));
		create_account.click();
		Thread.sleep(1000);
		
	
	}
	  
	  @Test(priority=2)
	  public void continue_signup() throws InterruptedException
	  {
			
			WebElement continuee=driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));
			continuee.click();
			Thread.sleep(1000);
			
		
	  }
	  @Test(priority=3)
	  public void logout_clck() throws InterruptedException
	  {
			
			WebElement logout=driver.findElement(By.xpath(" 	//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
			logout.click();	
			Thread.sleep(1000);
			
		
	  }
	    
	    // 6️⃣ Runs after each @Test method
	    @AfterMethod
	    public void afterMethod() {
	        System.out.println("🧩 AfterMethod: Test case finished");
	    }
	    
	    @AfterClass
	    public void afterClass() {
	        System.out.println("🧩 AfterClass: Completed all test methods in this class");
	    }

	 
	  @AfterTest
	  public void tearDown() {
	      driver.quit();
	  }
	// 9️⃣ Runs once after the entire test suite
	    @AfterSuite
	    public void afterSuite() {
	        System.out.println("🧩 AfterSuite: Test suite execution completed");
	    }
}