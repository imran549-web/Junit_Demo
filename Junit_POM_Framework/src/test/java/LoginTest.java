import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.org.base.TestBase;
import com.org.core.LoadProperties;

import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends TestBase{

	String userName = LoadProperties.readConfigProperty("username");

	String password = LoadProperties.readConfigProperty("password");

	String dashBoardURL = LoadProperties.readConfigProperty("DashBoardURL");

	HomePage homePage = null;

	@Before
	public void beforeTest() {
		homePage = launchTradeMeApp();	

	}

	@Test
	public void LoginTest() throws InterruptedException {
		homePage.clickLoginLink();

		LoginPage login = new LoginPage(driver);
		login.clearTextFields(login.emailInput);
		login.clearTextFields(login.passwordInput);
		login.enterEMail(userName).enterPassword(password).clickLoginButton();

		waitForSec(5);
		Assert.assertEquals(driver.getCurrentUrl(), dashBoardURL);


	}

	@After
	public void afterTest() throws IOException {
		driver.close();
	}





















}
