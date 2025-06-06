package com.onlinestore.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v131.serviceworker.model.ServiceWorkerErrorMessage;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By userName = By.xpath("//input[@id='input-email']");
	private By password = By.xpath("//input[@id='input-password']");
	private By clickLogin = By.xpath("//input[@value='Login']");
	private By allLinks = By.tagName("a");
	private By forgotPassword = By.xpath("//div[@class='form-group']//a[normalize-space()='Forgotten Password']");
	private By newCustomerHeading = By.xpath("//h2[normalize-space()='New Customer']");
	private By errorMessage = By.xpath("\n" + "//div[@class='alert alert-danger alert-dismissible']");

	// action

	public void enterUsername(String UserID) {
		actionDriver.type(userName, UserID);
	}

	public void enterPassword(String UserPwd) {
		actionDriver.type(password, UserPwd);

	}

	public void clickLogin() {
		actionDriver.click(clickLogin);

	}

	public String heading() {
		return actionDriver.getText(newCustomerHeading);

	}

	public boolean isforgortPwdEnabled() {
		return actionDriver.isEnabled(forgotPassword);

	}

	public void clickforgotPwd() {
		actionDriver.click(forgotPassword);

	}

	public int getTotalLinksOnPage() {
		List<WebElement> links = driver.findElements(allLinks);
		return links.size();
	}

	public boolean isErrorMsgDisplayed() {
		return actionDriver.isDisplayed(errorMessage);

	}
	
	public String getErrorMsg() {
		return actionDriver.getText(errorMessage);
		
	}

}
