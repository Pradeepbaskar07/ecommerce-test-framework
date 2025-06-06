package com.onlinestore.testdata;

import org.testng.annotations.DataProvider;

import java.util.UUID;
public class TestData {

    // validUserData
    @DataProvider(name = "userRegistrationDataStatic")
    public static Object[][] getUserRegistrationDataStatic() {
        return new Object[][] {
            { "John", "Doe", "john123@mail.com", "9876543210", "Password@123" },
            { "Alice", "Smith", "alice.smith@mail.com", "8765432109", "Pass@456" },
            { "Raj", "Kumar", "raj.kumar@mail.com", "9123456780", "Raj@789" },
            { "Emily", "Brown", "emily.brown@mail.com", "9988776655", "Emily@456" },
            { "David", "Lee", "david.lee@mail.com", "9090909090", "David@321" }
        };
    }
    // invalidUserData
    @DataProvider(name = "invalidUserData")
    public static Object[][] getInvalidUserData() {
        return new Object[][] {
            // Missing first name
            { "", "Doe", "invalid1@mail.com", "9876543210", "Test@123" },

            // Missing last name
            { "John", "", "invalid2@mail.com", "9876543210", "Test@123" },

            // Invalid email format
            { "Jane", "Smith", "not-an-email", "9876543210", "Test@123" },

            // Short password
            { "Alice", "Wonder", "alice@mail.com", "9876543210", "123" },

            // Missing phone number
            { "Bob", "Marley", "bob@mail.com", "", "Test@123" }
        };
    }
    //validLoginDetails
    @DataProvider(name = "loginData")
    public static Object[][]validLoginData(){
		return new Object[][] {
			{"alice.smith@mail.com","Pass@456"}
		};
    	
    }
    //invalidLoginDetails
    @DataProvider(name = "invalidLoginData")
    public static Object[][] invalidLoginData() {
        return new Object[][] {
            { "fakeuser@mail.com", "wrongpass" },
            { "", "Pass@456" },      // Empty email
            { "alice.smith@mail.com", "" }, // Empty password
            // More invalid scenarios...
        };
    }



    /*
    Random dynamic data (Commented for now)
    @DataProvider(name = "userRegistrationDataRandom")
    public static Object[][] getUserRegistrationDataRandom() {
        return new Object[][] {
            {
                "John_" + UUID.randomUUID().toString().substring(0, 5),
                "Doe_" + UUID.randomUUID().toString().substring(0, 5),
                "user_" + UUID.randomUUID().toString().substring(0, 5) + "@mail.com",
                "9876543210",
                "Test@123"
            }
        };
    }
    */
}



		