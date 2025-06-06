package com.onlinestore.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

	public RegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// locators

	private By enterFirstName = By.xpath("//input[@id='input-firstname']");
	private By lastName = By.xpath("//input[@id='input-lastname']");
	private By entreEmail = By.xpath("//input[@id='input-email']");
	private By enterTelephone = By.xpath("//input[@id='input-telephone']");
	private By enterPwd = By.xpath("//input[@id='input-password']");
	private By confirmPwd = By.xpath("//input[@id='input-confirm']");
	private By agree = By.xpath("//input[@name='agree']");
	private By enterContinue= By.xpath("//input[@value='Continue']");
	private By successMessage = By.cssSelector("#content h1");
    private By continueAfterSuccess = By.cssSelector("a.btn.btn-primary");
	
	
	//action class
	
	public void firstName(String fname) {
		actionDriver.type(enterFirstName, fname);
	}
	
	public void lastName(String lname) {
		actionDriver.type(lastName, lname);
		
	}
	
	public void email(String e_id) {
		actionDriver.type(entreEmail, e_id);
		
	}
	
	public void telephone(String t_no) {
		actionDriver.type(enterTelephone, t_no);	
		
	}
	
	public void password(String passkey) {
		actionDriver.type(enterPwd, passkey);
		
	}
	
	public void confirm_password(String confirm_passkey) {
		actionDriver.type(confirmPwd, confirm_passkey);
		
	}
	
	public void agree_privacy() {
		actionDriver.click(agree);
		
	}
	
	public void click_continue() {
		actionDriver.click(enterContinue);
		
	}
	
	public void registerNewUser(String fname, String lname, String e_id, String t_no, String passkey) {
	    firstName(fname);
	    lastName(lname);
	    email(e_id);
	    telephone(t_no);
	    password(passkey);
	    confirm_password(passkey);
	    agree_privacy();
	    click_continue();
	}
	
	public String accountSucessMsg() {
		return actionDriver.getText(successMessage);
		
	}
	public void clickContinueAfterSuccess() {
        actionDriver.click(continueAfterSuccess);
    }	
	
	// ✅ Shared locator for all alert messages (top banner)
	private By alertMessage = By.cssSelector(".alert.alert-danger");

	// ✅ Method 1: Check if any warning message is displayed
	public boolean isWarningDisplayed() {
	    return actionDriver.isDisplayed(alertMessage);
	}

	// ✅ Method 2: Fetch the actual warning message text
	public String getWarningMessage() {
	    return actionDriver.getText(alertMessage);
	}


	
}
