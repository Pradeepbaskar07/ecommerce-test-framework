package com.onlinestore.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	// locator
	
	private By myAccount = By.xpath("//span[text()='My Account']");
	private By register = By.linkText("Register");
	private By loginLink = By.linkText("Login");
	
	
	public void clickMyAccount() {
		actionDriver.click(myAccount);
		
	}
	
	public void clickRegister() {
		actionDriver.click(register);
		
	}
	
	public void clickLogin() {
		actionDriver.click(loginLink);
		
	}
	public void navigateToRegisterPage() {
		clickMyAccount();
		clickRegister();
		
	}
	public void navigateToLoginPage() {
		clickMyAccount();
		clickLogin();
		
	}
	
	

}
