package com.onlinestore.actiondriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.beust.jcommander.internal.Nullable;

public class ActionDriver {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	// constructor
	
	public ActionDriver(WebDriver driver,int explicit_wait) {
		this.driver= driver;
		this.wait= new WebDriverWait(driver,Duration.ofSeconds(explicit_wait));
	}
	
	public void click(By locator) {
		try {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
			element.click();
		} catch (Exception e) {
			System.out.println("unable to click :"+ e.getMessage());
		}
		
	}
	 public String getText(By locator) {
	        try {
	            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	            return element.getText();
	        } catch (Exception e) {
	            System.out.println(" Get text failed: " + e.getMessage());
	            return null;
	        }
	    }
	
	public void type(By locator, String value) {
		try {
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			element.clear();
			element.sendKeys(value);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("unable to find the element to type:"+e.getMessage());
		}
		
	}
	public boolean isDisplayed(By locator) {
		try {
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			return element.isDisplayed();
		} catch (Exception e) {
			System.out.println("element is not displayed:"+e.getMessage());
			// TODO: handle exception
			return false;
		}
		
	}
	public boolean isEnabled(By locator) {
	    try {
	        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	        return element.isEnabled(); // 
	    } catch (Exception e) {
	        System.out.println("element is not enabled: " + e.getMessage());
	        return false; 
	    }
	}

}
