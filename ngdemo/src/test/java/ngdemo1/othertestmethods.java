package ngdemo1;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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

public class othertestmethods {
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
		    
		    @Test
		    public void logo_verify() throws InterruptedException, TimeoutException
		    { 
		    	  System.out.println("🔍 DEBUG: Starting logo verification...");
		    	    System.out.println("Current URL: " + driver.getCurrentUrl());
		    	    System.out.println("Page Title: " + driver.getTitle());
		    	    // Print ALL images on the page
		    	    List<WebElement> allImages = driver.findElements(By.tagName("img"));
		    	    System.out.println("\n📸 Total images found on page: " + allImages.size());
		    	    List<WebElement> alllinks = driver.findElements(By.tagName("a"));
		    	    System.out.println("\n📸 Total links found on page: " + alllinks.size());
		    	    
		    	    // Wait for page to load
		    	    Thread.sleep(2000);
		    }
		    
		    
		    @Test
		    public void Go_On_TestCases() throws InterruptedException
		    {
		    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    	    WebElement testcases = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Test Cases")));
		    	    
		    	    Assert.assertTrue(testcases.isDisplayed(), "❌ Testcases button is not visible");
		    	    Assert.assertTrue(testcases.isEnabled(), "❌ Testcases button is not enabled");
		    	    
		    	    testcases.click();
		    	    
		    	    System.out.println("✅ Testcases button is visible and clickable");
		    }
		    
		    @Test
		    public void conatctus() throws InterruptedException
		    {
		    	WebElement contactus=driver.findElement(By.linkText("Contact us") );
		    	contactus.click();
		    
		    	WebElement username=driver.findElement(By.cssSelector("input[placeholder='Name']"));
		    	username.sendKeys("yjnjash");
		    	WebElement email=driver.findElement(By.cssSelector("input[placeholder='Email']"));
		    	email.sendKeys("sh@gmail.com");
		    	WebElement subject=driver.findElement(By.cssSelector("input[placeholder='Subject']"));
		    	subject.sendKeys("yash nmnmshjgbj,gbj,bjbj,bj");
		    	
		    	WebElement messagect=driver.findElement(By.id("message"));
		    	messagect.sendKeys("yash vhjgbj,gbj,bjbj,bjnbnmbmbmb");
		    	
		    	WebElement uploadfile=driver.findElement(By.xpath("//input[@name='upload_file']"));
		    	
		    	
		    	 // Provide the path of the file to upload
		        String filePath = "C:\\Users\\notieboie\\Desktop\\eclipse practice\\ngdemo\\test-output\\consultaCertidao.pdf"; // 🔹 Replace with your file path
		        uploadfile.sendKeys(filePath);

		        // Optional: verify if file input has value
		        String uploadedFile = uploadfile.getAttribute("value");
		        Assert.assertTrue(uploadedFile.contains("consultaCertidao.pdf"), "✅ File uploaded successfully");


		    	WebElement submit=driver.findElement(By.name("submit"));
		    	
		        submit.click();		      // Handle Alert
		        try {
		            Thread.sleep(1000); // small wait for alert to appear
		            Alert alert = driver.switchTo().alert(); // switch to alert
		            System.out.println("Alert Text: " + alert.getText()); // print alert text
		            alert.accept(); // click OK
		            System.out.println("✅ Alert accepted successfully");
		        } catch (NoAlertPresentException e) {
		            System.out.println("❌ No alert appeared after submit");
		        }

		        Thread.sleep(2000); // wait to observe
		        WebElement home_back=driver.findElement(By.cssSelector(" .fa.fa-angle-double-left"));
		        home_back.click();
		    }
		    
		    
		    
		    @Test
		    
		    public void subscripton()  throws InterruptedException
		    {
		    	WebElement subs=driver.findElement(By.id("susbscribe_email"));
		    	subs.sendKeys("yash@gmail.com");
		    	WebElement subsclick=driver.findElement(By.cssSelector(".fa.fa-arrow-circle-o-right"));
		    	subsclick.click();
		    	
		    	
		    	
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
