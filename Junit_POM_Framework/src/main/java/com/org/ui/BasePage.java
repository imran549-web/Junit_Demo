package com.org.ui;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/** Base page for page interactions , Parent class for all page classes */



/**
 * @author Imran
 *
 */

public class BasePage{

	private static final Logger logger = LoggerFactory.getLogger(BasePage.class);
	public static WebDriver driver;

	public WebDriverWait externalWait;


	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	


	/**
	 * Click on provided element
	 *
	 * @param element
	 * @
	 */
	public BasePage click(WebElement element)  {
		logger.info("Clicking the element in page");
		logger.info("BasePage Driver Value : " + driver);

		//     
		element.click();
		return  this;
	}

	/**
	 * Click using javascript, where ever synthetic click is required
	 *
	 * @param element
	 */
	public BasePage javaScriptClick(WebElement element) {
		logger.info("Javascript click ");
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		return  this;
	}
	/**
	 * Enter text in any text box
	 *
	 * @param element
	 * @param textToEnter
	 * @
	 */
	public BasePage enterText(WebElement element, String textToEnter)  {
		logger.info("Entering the text -" + textToEnter);

		element.sendKeys(textToEnter);
		return  this;
	}

	/**
	 * Enter text slowly in text box , use where need to enter text slowly
	 *
	 * @param element
	 * @param textToEnter
	 * @throws InterruptedException
	 * @
	 */
	public BasePage enterTextSlowly(WebElement element, String textToEnter)
			throws InterruptedException {
		logger.info("Typing characters slowly --" + textToEnter);

		char[] chars = textToEnter.toCharArray();
		for (char character : chars) {
			Thread.sleep(10);
			element.sendKeys(Character.toString(character));
		}
		return this;
	}

	/**
	 * Method to clear the text fields
	 * @param element
	 * @return
	 * @
	 */
	public BasePage clearTextFields(WebElement element)  {

		element.clear();
		logger.info("Clearing Text fileds:"+element);
		return this;
	}

	/**
	 * Method to enter text by clearing the existing text 
	 * @param element
	 * @param textToEnter
	 * @return
	 * @
	 */
	public BasePage enterTextByClearingFields(WebElement element,String textToEnter)  {

		element.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),textToEnter);
		return this;
	}

	/**
	 * Enter text slowly after clearing the text box , use where need to enter text slowly
	 *
	 * @param element
	 * @param textToEnter
	 * @throws InterruptedException
	 * @
	 */
	public BasePage enterTextSlowlyByClearingFields(WebElement element, String textToEnter)
			throws InterruptedException {
		logger.info("Typing characters slowly after clearing the text--" + textToEnter);
		element.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END));

		char[] chars = textToEnter.toCharArray();
		for (char character : chars) {
			Thread.sleep(10);
			element.sendKeys(Character.toString(character));
		}
		return this;
	}


	/**
	 *
	 * @param element
	 * @return
	 */
	public String getText(WebElement element){
		return element.getText();
	}
	// method to select the value from the dropdown
	public BasePage selectValueFromDropdown(WebElement selectElement, String value) {
		boolean isSelected = false;
		if (selectElement != null || value != null) {
			Select select = new Select(selectElement);
			if (!isSelected) {
				try {
					select.selectByIndex(Integer.parseInt(value));
					isSelected = true;
				} catch (Exception e) {
					isSelected = false;
				}
			}
			if (!isSelected) {
				try {
					select.selectByVisibleText(value);
					isSelected = true;
				} catch (Exception e) {
					isSelected = false;
				}
			}
			if (isSelected == false) {
				try {
					select.selectByValue(value);
					isSelected = true;
				} catch (Exception e) {
					isSelected = false;
				}
			}

		} else {
			logger.info("Element locator or  value is not set");
		}

		return this;
	}
	/*
	 * Method to launch website with an given URL
	 */
	public void NavigateTo(String URL) {
		try {
			URL = java.net.URLDecoder.decode(URL, "UTF-8");
			driver.navigate().to(URL);
			logger.info("Launching URL: " + URL);
		} catch (Exception e) {

		}
	}

	public void elementToBeClickable(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.elementToBeClickable(element));

	}


}
