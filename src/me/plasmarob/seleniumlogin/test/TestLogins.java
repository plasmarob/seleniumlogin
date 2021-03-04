package me.plasmarob.seleniumlogin.test;

import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import me.plasmarob.seleniumlogin.pages.feederfam.*;
import me.plasmarob.seleniumlogin.pages.google.*;

// As of January 2021 Google blocks Selenium and other automation software from logging in.
// If we wanted to actually test a login, rumor has it:
// Puppeteer would work (with NodeJS) https://developers.google.com/web/tools/puppeteer/
// If our automation was already in Java, we could use Trireme to run Puppeteer (Node) scripts from here https://github.com/apigee/trireme
// or possibly use Playwright https://playwright.dev/

public class TestLogins {

	protected String geckoDriverPATH = "C:/Program Files/Mozilla Firefox/geckodriver.exe";
	protected WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", geckoDriverPATH);
		driver = new FirefoxDriver();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	// Will fail, since Google blocks automation
	@Test
	public void testGoogleLogin() throws InterruptedException {
		// Go to google.com
		GoogleMainPage mainPage = new GoogleMainPage(driver);
		String email="modulustreesuite@gmail.com";
		// click "Sign in"
		AccountPage emailPage = mainPage.signIn();
		PassPage passPage = emailPage.passValidEmail(email);
		Thread.sleep(3000);
		// Should fail since we can't get here, as follows:
		// org.openqa.selenium.NoSuchElementException: Unable to locate element:
		// *[name='password']
		assertEquals("Enter your password", passPage.getTextLabel());
	}

	@Test
	public void testFeederfamLogin() throws InterruptedException {
		String username = "testaccount";
		String password = "appleclockbathtime"; // some random words my toddlers know

		// Go to feederfam.com and create home page object
		driver.get("https://www.feederfam.com/");
		HomePage outHomePage = new HomePage(driver);
		// click "Login"
		LoginPage signInPage = outHomePage.clickLogin();
		// Input and submit user and pass
		HomeLoggedInPage inHomePage = signInPage.passValidUser(username,password);
		Thread.sleep(3000);
		// Assert the user I made (first name "Test") is displayed on the logout button
		assertEquals("Test",inHomePage.getUserDisplayName());
	}

	@Test
	public void testFeederfamLogout() throws InterruptedException {
		String username = "testaccount";
		String password = "appleclockbathtime"; // some random words my toddlers know

		// Go to feederfam.com and create home page object
		driver.get("https://www.feederfam.com/");
		HomePage homePage = new HomePage(driver);
		// click "Login"
		LoginPage signInPage = homePage.clickLogin();
		// Input and submit user and pass
		HomeLoggedInPage inHomePage = signInPage.passValidUser(username, password);
		Thread.sleep(1000);
		HomePage homePage2 = inHomePage.signOut();
		
		// Assert the login option is back
		assertEquals("https://feederfam.com/login", homePage2.getLoginLink());
	}
	
}
