package phptravels.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import phptravels.TestComponents.BaseTest;
import phptravels.pageobjects.SignUpPage;

public class SignUpCustomerCode extends BaseTest {

	@Test
	public void SignUp() throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		
		SignUpPage signuppage = SignUplaunchApplication();
		Properties prop = new Properties(); //comes in util package
		FileInputStream fis = new 
				FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\phptravels\\resources\\CustomerData.properties"); // Convert the file into input stream object so that you can send inside this load().
		prop.load(fis);   //Here it load the global properties file. This method parse the Global properties file and extract all the key-value pair.
		String getFirstname = prop.getProperty("firstname");
		String getLastname = prop.getProperty("lastname");
		String getPhone = prop.getProperty("phone");
		String getEmail = prop.getProperty("email");
		String getPassword = prop.getProperty("password");
		signuppage.SignUpApplication(getFirstname,getLastname,getPhone,getEmail,getPassword);
		signuppage.NavigateToLoginPage(getEmail, getPassword);
		driver.close();
	//	.alert.alert-success.signup
	}

}
