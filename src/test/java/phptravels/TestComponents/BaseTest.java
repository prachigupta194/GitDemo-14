package phptravels.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import phptravels.pageobjects.LoginCustomer;
import phptravels.pageobjects.LoginPage;
import phptravels.pageobjects.SignUpPage;

public class BaseTest {
	
	public WebDriver driver;
	public LoginPage loginPage;
	public SignUpPage signuppage;
	public LoginCustomer loginCustomer;
	
	public WebDriver initializeDriver() throws IOException
	{
			
			//properties class
			
			Properties prop = new Properties(); //comes in util package
			FileInputStream fis = new 
					FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\phptravels\\resources\\GlobalData.properties"); // Convert the file into input stream object so that you can send inside this load().
			prop.load(fis);   //Here it load the global properties file. This method parse the Global properties file and extract all the key-value pair.
			String browserName = prop.getProperty("browser");
			
			if(browserName.equalsIgnoreCase("chrome"))
			{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

			}
			//Firefox
			else if(browserName.equalsIgnoreCase("firefox"))
			{
			System.setProperty("webdriver.geko.driver", "E:\\Webdrivers\\Firefox\\gekodriver.exe");
			driver = new FirefoxDriver();
			}
			//Edge
			else if(browserName.equalsIgnoreCase("edge"))
			{
			System.setProperty("webdriver.edge.driver", "E:\\Webdrivers\\Edge\\msedgedriver.exe");
			driver = new EdgeDriver();
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
			driver.manage().window().maximize();
			return driver;
			
}
	public LoginPage LoginlaunchApplication() throws IOException
		{		
			driver = initializeDriver();
			loginPage = new LoginPage(driver);
			loginPage.goTo();
			return loginPage;
		}
	public SignUpPage SignUplaunchApplication() throws IOException, InterruptedException
	{		
		   driver = initializeDriver();
		   signuppage = new SignUpPage(driver);
		   signuppage.goTo();
		   return signuppage;
	}
	public LoginCustomer LoginCustomerlaunchApplication() throws IOException, InterruptedException
	{		
		   driver = initializeDriver();
		   loginCustomer = new LoginCustomer(driver);
		   loginCustomer.goTo();
		   return loginCustomer;
	}

}
