package phptravels.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigationLinksCustomerRawCode {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		// Sign up - https://phptravels.net/login - Navigate to the login page
		driver.get("https://phptravels.net/login");
		
		// Navigate to the login page
		driver.findElement(By.id("cookie_stop")).click();
		driver.findElement(By.cssSelector("input[type*='email']")).sendKeys("abc@test.com");
		driver.findElement(By.cssSelector("input[type*='password']")).sendKeys("abc@123");
		driver.findElement(By.cssSelector("button[type*='submit']")).click();
		
		
		//Verify that the user is navigated to the Bookings Page
		driver.findElement(By.cssSelector(".la.la-shopping-cart.mr-2.text-color-3")).click();
		Thread.sleep(2000);
		
		//Verify that the user is navigated to the Add Funds Page
		driver.findElement(By.cssSelector(".la.la.la-wallet.mr-2.text-color-9")).click();
		Thread.sleep(2000);
		
		//Verify that the user is navigated to the My Profile Page
	    driver.findElement(By.cssSelector(".la.la-user.mr-2.text-color-2")).click();
	    Thread.sleep(2000);
		//Verify that the user is navigated to the Logout Page
//		driver.findElement(By.cssSelector(".la.la.la-power-off.mr-2.text-color-6")).click();
		
	    //Verify that the currency dropdown gets opened.
		driver.findElement(By.cssSelector("div.header-right-action.pt-1.pe-2.multi_currency")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("INR")).click();
		Thread.sleep(2000);
		
		//Verify that the Account dropdown gets opened.
		//ul[@class='btn btn-default dropdown-toggle waves-effect']
		driver.findElement(By.xpath("(//div[@class='header-right-action pt-1 pe-2'])[1]")).click();
		Thread.sleep(2000);
		//Verify that the user is navigated to the Dashboards Page through Account dropdown
		driver.findElement(By.xpath("//a[text()=' Dashboard']")).click();
		Thread.sleep(2000);
		
		//Verify that the user is navigated to the Bookings Page through Account dropdown
		driver.findElement(By.xpath("(//div[@class='header-right-action pt-1 pe-2'])[1]")).click();
		driver.findElement(By.xpath("//a[text()=' My Bookings']")).click();
		Thread.sleep(2000);
		
		//Verify that the user is navigated to the Add Funds Page  through Account dropdown
		driver.findElement(By.xpath("(//div[@class='header-right-action pt-1 pe-2'])[1]")).click();
		driver.findElement(By.xpath("//a[text()=' Add Funds']")).click();
		Thread.sleep(2000);
		
		//Verify that the user is navigated to the My Profile Page through Account dropdown
		driver.findElement(By.xpath("(//div[@class='header-right-action pt-1 pe-2'])[1]")).click();
		driver.findElement(By.xpath("//a[text()=' My Profile']")).click();
		
		
//		//Verify that the user is navigated to the Logout Page through Account dropdown
//		driver.findElement(By.xpath("(//div[@class='header-right-action pt-1 pe-2'])[1]")).click();
//		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		
		//Verify that the user is navigated to the Flights Page
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a.active_flights.waves-effect")).click();
		driver.navigate().back();
		
	}

}
