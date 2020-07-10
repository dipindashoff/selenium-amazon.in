package com.amazon.testRunner;

import com.amazon.pageActions.LoginScreen;
import com.amazon.pageActions.PDPScreen;
import com.amazon.pageActions.SearchScreen;
import com.amazon.resuables.CommonMethods;
import com.amazon.resuables.ExcelMethods;
import com.relevantcodes.extentreports.LogStatus;

public class TestRunner extends CommonMethods{

	public static void main(String[] args) {

		// Create objects
		CommonMethods common = new CommonMethods();
		LoginScreen login = new LoginScreen();
		SearchScreen search = new SearchScreen();
		PDPScreen pdp = new PDPScreen();
		ExcelMethods excel = new ExcelMethods();

		// Launch amazon.in
		common.launchBrowser();
		// Sign in
//		login.signIn();

		// Go to menu Mobiles tabs -> Laptops
		search.navigateToLaptopSearchResultsScreen();
		// Filter facet by Apple, and 4 star rating
		search.filterByBrand();
		search.filterByRating();
		// Sort by Price Highest to Low
		search.sortByPriceDesc();
		// Click Laptop link
		search.selectFirstLaptop();
		// Go to PDP screen
		// Copy display spec on an excel.notepad
		// Add 3 items to cart
		pdp.copySpec();
		
		excel.writeToExcel("Deesha");
		
		common.startExtentReport();
		test.log(LogStatus.PASS, "Description of screenshot" + test.addScreenCapture("screenshot-path"));
		common.endExtentReport();

		// Close browser
		common.tearDown();
	}

}
