package phptravels.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import phptravels.TestComponents.BaseTest;
import phptravels.pageobjects.LoginPage;

public class LoginLogoutAdminCode extends BaseTest {

	@Test
	public void login() throws IOException, InterruptedException {
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		LoginPage loginPage = new LoginPage(driver);
//		loginPage.goTo();
		LoginPage loginPage = LoginlaunchApplication();
		Properties prop = new Properties(); //comes in util package
		FileInputStream fis = new 
				FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\phptravels\\resources\\AdminData.properties"); // Convert the file into input stream object so that you can send inside this load().
		prop.load(fis);   //Here it load the global properties file. This method parse the Global properties file and extract all the key-value pair.
		String getUsername = prop.getProperty("username");
		String getPassword = prop.getProperty("password");
		loginPage.loginApplication(getUsername,getPassword);
		loginPage.logoutApplication();
		driver.close();
	}

}
