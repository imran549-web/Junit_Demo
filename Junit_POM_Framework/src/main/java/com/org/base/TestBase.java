package com.org.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.org.core.LoadProperties;
import com.org.ui.BasePage;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.LoginPage;

public class TestBase {

	//would be used across my base class, hence keeping them global
	public static WebDriver driver=null;
	public static EventFiringWebDriver envDriver =null;
	public static boolean isLoggedIn=false;

	public WebDriver getDriver() throws IOException {

		if (envDriver == null) {
			String browser = LoadProperties.readConfigProperty("browser");

			if (browser.equals("Chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} //else can be added if  we need to add more browser if required

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		return driver;

	}

	public HomePage launchTradeMeApp()
	{
		try {
			driver = getDriver();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BasePage basePage = new BasePage(driver);
		basePage.NavigateTo(LoadProperties.getAppUrl());
		return new HomePage(driver);
	}

	public void waitForSec(int sec)
	{
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
