package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.org.ui.BasePage;

public class HomePage extends BasePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}

	private static final Logger logger = LoggerFactory.getLogger(HomePage.class);


	@FindBy(xpath = "//*[@id=\"LoginLink\"]")
	public WebElement loginLink;

	public HomePage clickLoginLink() {
		click(loginLink);
		return this;
	}	
}