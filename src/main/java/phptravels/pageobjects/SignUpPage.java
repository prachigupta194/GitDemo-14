package phptravels.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
	
	WebDriver driver;

	public SignUpPage(WebDriver driver) {

		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this); // this will trigger initializing all the elements

	}

//	WebElement userEmail = driver.findElement(By.id("email"));
//  Page Factory - We can reduce the syntax of creating web element
//  @FindBy is the annotation name

	@FindBy(name = "first_name") // It will use the first driver as an argument and initialization with 'this'.
	WebElement firstName;

	@FindBy(name = "last_name")
	WebElement lastName;

	@FindBy(name = "phone")
	WebElement userPhone;
	
	@FindBy(name = "email")
	WebElement Email;
	
	@FindBy(name = "password")
	WebElement Password;

	@FindBy(css = "button[id = 'button']")
	WebElement Signup;


	public void SignUpApplication(String first_name, String last_name, String user_phone, String user_email, String user_password) throws InterruptedException // Action Method
	{
		
		firstName.sendKeys(first_name); // userEmail will have construction like this
									// driver.findElement(By.id("email"));
		lastName.sendKeys(last_name);
		userPhone.sendKeys(user_phone);
		Email.sendKeys(user_email);
		Password.sendKeys(user_password);
		Thread.sleep(20000);
		Signup.click();
	}

	public void goTo() throws InterruptedException {
		
		driver.get("https://phptravels.net/login");
		Thread.sleep(1000);
		driver.findElement(By.id("cookie_stop")).click();
		driver.findElement(By.cssSelector("a[class*='align-items-center']")).click();

	}
	public void NavigateToLoginPage(String user_email, String user_password) throws InterruptedException {
		
		
	//	driver.findElement(By.cssSelector(".alert.alert-success.signup")).getText();
	//	Assert.assertEquals((driver.findElement(By.cssSelector(".alert.alert-success.signup")).getText()), "Signup successful please login.");
    //  System.out.println(driver.findElement(By.cssSelector(".alert.alert-success.signup")).getText());
        
        Thread.sleep(1000);
		Email.sendKeys(user_email);
		Password.sendKeys(user_password);
		driver.findElement(By.cssSelector("button[type*='submit']")).click();
	//	.alert.alert-success.signup
        
	}

}
