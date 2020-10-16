package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.org.ui.BasePage;

public class LoginPage extends BasePage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}

	private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);

	@FindBy(id = "page_email")
	public WebElement emailInput;	

	@FindBy(id = "page_password")
	public WebElement passwordInput;

	@FindBy(id = "LoginPageButton")
	public WebElement loginButton;	


	public LoginPage enterEMail(String userMail) {
		enterText(emailInput, userMail);
		return this;
	}

	public LoginPage enterPassword(String password) {
		enterText(passwordInput, password);
		return this;
	}

	public LoginPage clickLoginButton() {
		click(loginButton);
		return this;
	}	

}