package com.ibm.fst.nopcomm.exercise.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ibm.fst.nopcomm.exercise.utility.BaseTest;



public class LoginTest extends BaseTest {
	
	@DataProvider(name ="login")
	public Object[][] getTestData(){
		return new Object[][] {
			{"admin@yourstore.com","admin",false,"Your store. Login","Dashboard / nopCommerce administration"}
			
		};
	}
	
	@Test(dataProvider = "login")
	public void verifyLoginFunctionality(String username,String password,boolean remCheck,
			String beforeLog,String afterLog) throws Exception {
		
		
		
		loginPage.verifyApplicationTitle(beforeLog);
		
		loginPage.logIn(username, password, remCheck);
		
		loginPage.verifyApplicationTitle(afterLog);
		
	}

}
