package phptravels.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SignUpCustomerRawCode {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

        //Set up Chrome WebDriver       
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//Maximize window
		driver.manage().window().maximize();
		
        //Implement the implicit wait	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Sign up - https://phptravels.net/login - Navigate to the login page
		driver.get("https://phptravels.net/login");
		
		// Navigate to the sign-up page
		driver.findElement(By.id("cookie_stop")).click();
		
		// Fill in the registration form
		driver.findElement(By.cssSelector("a[class*='align-items-center']")).click();
		driver.findElement(By.cssSelector("input[placeholder = 'First Name']")).sendKeys("Prachi");
		driver.findElement(By.cssSelector("input[placeholder = 'Last Name']")).sendKeys("Gupta");
		driver.findElement(By.cssSelector("input[placeholder = 'Phone']")).sendKeys("3893748374");
		driver.findElement(By.cssSelector("input[placeholder = 'Email']")).sendKeys("abc@test.com");
		driver.findElement(By.cssSelector("input[placeholder = 'Password']")).sendKeys("abc@123");
        
//      div[@class='rc-anchor-center-item rc-anchor-checkbox-holder']
//		WebElement iFrame = driver.findElement(By.id("rc-anchor-container"));
//	    driver.switchTo().frame(iFrame);

//	    WebElement iFrame_checkbox = driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']"));
//	    driver.switchTo().frame(iFrame_checkbox);
//      driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
//		driver.findElement(By.className("recaptcha-checkbox-borderAnimation")).click();
		Thread.sleep(3000);
		
		//Verify that the user has signed up
		driver.findElement(By.cssSelector(".form-group.mt-3")).click();

		//Verify that the user is logged in
		driver.findElement(By.cssSelector("input[type*='email']")).sendKeys("abc@test.com");
		driver.findElement(By.cssSelector("input[type*='password']")).sendKeys("abc@123");
		driver.findElement(By.cssSelector("button[type*='submit']")).click();
		
	}

}
