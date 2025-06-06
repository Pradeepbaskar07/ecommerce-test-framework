package com.onlinestore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.onlinestore.actiondriver.ActionDriver;
import com.onlinestore.config.ConfigReader;

public class BasePage {
	
	protected WebDriver driver;
	protected ActionDriver actionDriver;
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
		// Getting explicit wait from config reader
		int explicitwait = Integer.parseInt(ConfigReader.getProperty("explicit_wait"));
		
		// intizing a action driver 
		this.actionDriver = new ActionDriver(driver, explicitwait);
		
		PageFactory.initElements(driver, this);
		
	}
	

}
