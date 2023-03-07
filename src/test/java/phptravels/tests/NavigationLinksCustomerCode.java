package phptravels.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import phptravels.TestComponents.BaseTest;
import phptravels.pageobjects.LoginCustomer;
import phptravels.pageobjects.NavigationLinks;


public class NavigationLinksCustomerCode extends BaseTest{

	@Test
	public void NavigationLink() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
        LoginCustomer logincustomer = LoginCustomerlaunchApplication();
        Properties prop = new Properties(); //comes in util package
		FileInputStream fis = new 
				FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\phptravels\\resources\\CustomerData.properties"); // Convert the file into input stream object so that you can send inside this load().
		prop.load(fis);  
		String getEmail = prop.getProperty("email");
		String getPassword = prop.getProperty("password");
		logincustomer.loginCustomerApplication(getEmail,getPassword);
		NavigationLinks navigationlink =  new NavigationLinks(driver);
		navigationlink.NavigationLinkTab();
		navigationlink.DropDown();
	}

}
