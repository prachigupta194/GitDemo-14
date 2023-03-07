package phptravels.pageobjects;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import phptravels.AbstractComponents.AbstractComponent;

public class NavigationLinks extends AbstractComponent {

	WebDriver driver;
	
	
	public NavigationLinks(WebDriver driver) {
        
		super(driver);
		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this); // this will trigger initializing all the elements
}

//	WebElement userEmail = driver.findElement(By.id("email"));
//  Page Factory - We can reduce the syntax of creating web element
//  @FindBy is the annotation name

	@FindBy(css = ".la.la-shopping-cart.mr-2.text-color-3") // It will use the first driver as an argument and initialization with 'this'.
	WebElement BookingsPage;

	@FindBy(css = ".la.la.la-wallet.mr-2.text-color-9")
	WebElement AddFundsPage;

	@FindBy(css = ".la.la-user.mr-2.text-color-2")
	WebElement MyProfilePage;
	
	@FindBy(css = ".la.la.la-power-off.mr-2.text-color-6")
	WebElement LogoutPage;
	
	@FindBy(css = "div.header-right-action.pt-1.pe-2.multi_currency")
	WebElement CurrencyDropdown;

	@FindBy(linkText = "INR")
	WebElement I_N_R;
	
	@FindBy(css = ".btn.btn-primary.dropdown-toggle.waves-effect")
	WebElement AccountDropdown;
	
	@FindBy(xpath = "//a[text()=' Dashboard']")
	WebElement AccountsDashboardPage;
	
	@FindBy(xpath = "//a[text()=' My Bookings']")
	WebElement AccountsBookingsPage;
	
	@FindBy(xpath = "//a[text()=' Add Funds']")
	WebElement AccountsAddFundsPage;
	
	@FindBy(xpath = "//a[text()=' My Profile']")
	WebElement AccountsMyProfilePage;
	
	@FindBy(xpath = "//a[text()=' Logout']")
	WebElement AccountsLogoutPage;
	
	By bookings = By.cssSelector(".la.la-shopping-cart.mr-2.text-color-3");
	By accountsDropdown = By.cssSelector(".btn.btn-primary.dropdown-toggle.waves-effect");

	public void NavigationLinkTab() throws InterruptedException // Action Method
	{
		waitForElementToAppear(bookings);
		BookingsPage.click(); // userEmail will have construction like this
									 //driver.findElement(By.id("email"));
	//	waitForElementToAppear(addfunds);
		AddFundsPage.click();
		MyProfilePage.click();
	//	LogoutPage.click();
	}
	
	public void DropDown() throws InterruptedException // Action Method
	{
		
		CurrencyDropdown.click(); // userEmail will have construction like this
									// driver.findElement(By.id("email"));
		I_N_R.click();
//		waitForElementToAppear(accountsDropdown);
//		AccountDropdown.click();
//		AccountsDashboardPage.click();
//		
//		AccountDropdown.click();
//		AccountsBookingsPage.click();
//		
//		AccountDropdown.click();
//		AccountsAddFundsPage.click();
//		
//		AccountDropdown.click();
//		AccountsMyProfilePage.click();

//	    AccountDropdown.click();
//		AccountsLogoutPage.click();
		
		List<WebElement> pages = Arrays.asList(AccountsDashboardPage, AccountsBookingsPage, AccountsAddFundsPage, AccountsMyProfilePage, AccountsLogoutPage);

		for (WebElement page : pages) {
			waitForElementToAppear(accountsDropdown);
			AccountDropdown.click();
			WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(20));
			w.until(ExpectedConditions.visibilityOf(page));
		    page.click();
		    
		    
		}
		Thread.sleep(1000);
		driver.close();
	}
	
}
