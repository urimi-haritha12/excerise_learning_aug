package com.ibm.fst.nopcomm.exercises.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Webdrive;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CustSearchPage {
	
	Webdrive drive;

	public CustSearchPage(Webdrive rdrive) {

		drive = rdrive;
		PageFactory.initElements(rdrive, this);

	}
	

		@FindBy(xpath = "//div[@class='content-header']")
		WebElement dashboardtxt;

		@FindBy(xpath = "//i[@class='nav-icon far fa-user']//following-sibling::p")
		WebElement customermenu;

		@FindBy(xpath = "//p[text()=' Customers']")
		WebElement customerSubmenu;

		@FindBy(id = "SearchEmail")
		WebElement txtsearchemail;

		@FindBy(css = "button#search-customers")
		WebElement buttSearch;

		@FindBy(xpath = "//a[text()='John Smith']")
		WebElement logintxt;

		@FindBy(xpath = "//table[@id='customers-grid']//tbody//tr")
		List<WebElement> rows;

		@FindBy(xpath = "//table[@id='customers-grid']//tbody//tr[1]//td")
		List<WebElement> cols;



		public void verifyHomepage(String expDBTxt) {

			Assert.assertEquals(dashboardtxt.getText(), expDBTxt);
			boolean isDisplay = logintxt.isDisplayed();
			Assert.assertTrue(isDisplay);

		}

		public void clickonCustmenu() {

			customermenu.click();
			customerSubmenu.click();
		}

		public void searchCustomer(String criteria, String crtVal) throws InterruptedException {

			

			if (criteria.equals("email")) {

				txtsearchemail.clear();
				txtsearchemail.sendKeys(crtVal);
			}

		
			buttSearch.click();
			Thread.sleep(1000);

		}

		public void validateCustResult(String email, String name) {

		
			int rowCount = rows.size();
			int colCount = cols.size();
			String emailVal = "";
			String nameVal = "";
			System.out.println(rowCount);
			System.out.println(colCount);
			for (int i = 1; i <= rowCount; i++) {
				
				emailVal =drive.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText(); 
				nameVal =drive.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[3]")).getText();
				if(emailVal.equalsIgnoreCase(email) && nameVal.equalsIgnoreCase(name)) {
					Assert.assertTrue(true); 
				}

		}

		}

}
