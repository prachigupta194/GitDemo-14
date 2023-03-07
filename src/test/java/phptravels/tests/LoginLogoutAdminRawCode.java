package phptravels.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginLogoutAdminRawCode {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String email = "admin@phptravels.com";
		String password = "demoadmin";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Login - https://phptravels.net/api/admin
		driver.get("https://phptravels.net/api/admin");
		
		//Enter the credentials
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.className("ladda-label")).click();

		// Logout - https://phptravels.net/api/admin
		driver.findElement(By.id("dropdownMenuProfile")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[normalize-space()='Logout']")).click();

	}

}
