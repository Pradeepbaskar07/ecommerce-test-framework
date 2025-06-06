package com.onlinestore.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.onlinestore.basefile.BaseTest;
import com.onlinestore.pageobjects.HomePage;
import com.onlinestore.pageobjects.LoginPage;
import com.onlinestore.testdata.TestData;

    public class Login_test extends BaseTest {
    	
    	private LoginPage loginPage;
    	
    	@BeforeMethod
        public void goToLoginPage() {
            HomePage homePage = new HomePage(driver);
            homePage.navigateToLoginPage();
            loginPage = new LoginPage(driver);
        }
    	
    	 @Test(dataProvider = "validLoginData", dataProviderClass = TestData.class)
    	 public void verifyValidUser(String email, String password){
    		 loginPage.enterUsername(email);
    		 loginPage.enterPassword(password);
    		 loginPage.clickLogin();
    		 Assert.assertTrue(driver.getTitle().contains("My Account"), "Login Failed");
    		 
    	 }
    	 
    	 @Test(dataProvider = "invalidLoginData", dataProviderClass = TestData.class)
    	 public void verifyInvalidLogin(String email,String password) {
    		 loginPage.enterUsername(email);
    		 loginPage.enterPassword(password);
    		 loginPage.clickLogin();
    		 Assert.assertTrue(loginPage.isErrorMsgDisplayed(),"error msg not displayed for invalidlogin");
    		 
    	 }
    	

	}
	
	
	
	


