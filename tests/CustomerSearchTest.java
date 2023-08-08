package com.ibm.fst.nopcomm.exercise.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ibm.fst.nopcomm.exercise.utility.BaseTest;

public class custSearchTest extends BaseTest {
	
	@DataProvider(name="CustomerSearch")
	public Object[][] getTestData(){
		return new Object[][] {
			{"admin@yourstore.com","admin",false,"Dashboard","email","admin@yourstore.com","John Smith"}
			
		};
	}
	
	@Test(dataProvider = "CustomerSearch")
	public void verifyCustFunctionality(String username,String password,boolean remCheck,String dashBoardtxt,
			String criteria, String criteriaValue,String name ) throws Exception {
		
		loginPage.logIn(username, password, remCheck);
		custSearchPage.verifyHomepage(dashBoardtxt);
		
		custSearchPage.clickonCustmenu();
		
		custSearchPage.searchCustomer(criteria, criteriaValue);
		
		custSearchPage.validateCustResult(criteriaValue,name);
		
	}

}
