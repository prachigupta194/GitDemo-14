package phptravels.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this); // this will trigger initializing all the elements

	}

//	WebElement userEmail = driver.findElement(By.id("email"));
//  Page Factory - We can reduce the syntax of creating web element
//  @FindBy is the annotation name

	@FindBy(name = "email") // It will use the first driver as an argument and initialization with 'this'.
	WebElement userEmail;

	@FindBy(name = "password")
	WebElement userPassword;

	@FindBy(className = "ladda-label")
	WebElement Login;

	public void loginApplication(String user_name, String pass_word) // Action Method
	{
		userEmail.sendKeys(user_name); // userEmail will have construction like this
									// driver.findElement(By.id("email"));
		userPassword.sendKeys(pass_word);
		Login.click();

	}

	public void goTo() {
		driver.get("https://phptravels.net/api/admin");

	}

	public void logoutApplication() throws InterruptedException // Action Method
	{

		driver.findElement(By.id("dropdownMenuProfile")).click();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space()='Logout']")));
		driver.findElement(By.xpath("//div[normalize-space()='Logout']")).click();

	}
}
