package com.onlinestore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.onlinestore.basefile.BaseTest;
import com.onlinestore.pageobjects.HomePage;
import com.onlinestore.pageobjects.RegisterPage;
import com.onlinestore.testdata.TestData;

public class Registration_test extends BaseTest {
	
    @Test( priority = 1 ,dataProvider = "userRegistrationDataStatic", dataProviderClass = TestData.class)
    public void verifyUserCanRegisterSucessfully(String fname, String lname, String e_id, String t_no, String passkey) {
    	
    	HomePage homePage = new HomePage(driver);
    	homePage.navigateToRegisterPage();
    	
    	RegisterPage registerPage = new RegisterPage(driver);
    	registerPage.registerNewUser(fname, lname, e_id, t_no, passkey);
    	
    	String actualSucessMsg = registerPage.accountSucessMsg();
    	Assert.assertEquals(actualSucessMsg, "Your Account Has Been Created!", "❌ Registration failed.");
    	
    	registerPage.clickContinueAfterSuccess();
    	Assert.assertTrue(driver.getTitle().contains("My Account"),"my account page not reached ");
    }
	
    @Test( priority = 2, dataProvider = "invalidUserData", dataProviderClass = TestData.class)
    public void verifyRegistrationFailsWithInvalidUserData(String fname,String lname, String e_id, String t_no, String passkey) {
    	
    	HomePage homePage=new HomePage(driver);
    	homePage.navigateToRegisterPage();
    	
    	RegisterPage registerPage = new RegisterPage(driver);
    	registerPage.registerNewUser(fname, lname, e_id, t_no, passkey);
    	String warningMessage = registerPage.getWarningMessage();
    	Assert.assertTrue(registerPage.isWarningDisplayed(), "Warning Not displayed");
    	System.out.println("warningMSG:"+ warningMessage);
    	
    
    }
    
    @Test( priority = 3,dataProvider = "userRegistrationDataStatic", dataProviderClass = TestData.class)
    public void verifyExistingCustomerFailure(String fname,String lname, String e_id, String t_no, String passkey) {
    	
    	HomePage homePage = new HomePage(driver);
    	homePage.navigateToRegisterPage();
    	
    	RegisterPage registerPage = new RegisterPage(driver);
    	registerPage.registerNewUser(fname, lname, e_id, t_no, passkey);
    	
    	String warningMsg = registerPage.getWarningMessage();
    	Assert.assertTrue(warningMsg.contains("Warning: E-Mail Address is already registered!"), " Expected duplicate email warning not shown. Actual message: "+warningMsg);
    	
    
	}
    
    
    

}
