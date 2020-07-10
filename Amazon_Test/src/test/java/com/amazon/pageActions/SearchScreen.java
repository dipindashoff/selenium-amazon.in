package com.amazon.pageActions;

import org.openqa.selenium.By;

import com.amazon.pageObjects.POForSearchScreen;
import com.amazon.resuables.CommonMethods;

public class SearchScreen extends CommonMethods implements POForSearchScreen {

	/**
	 * Search screen
	 */
	public void navigateToLaptopSearchResultsScreen() {

		try {
			// Click hamburger
			click(hamburgerIcon);
			// Click Mobiles, Laptops link
			click(menuMobilesLaptops);
			// Scroll to Laptops menu
			scrollToView(menuLaptops);
			// Click Laptops menu
			click(menuLaptops);
			switchToCurrentWindow();
			wait(headerLaptops);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Filter by Apple
	 */
	public void filterByBrand() {

		try {
			By facetBrandApple = By.xpath("//span[text()='Apple']/parent::span/preceding-sibling::input");
			scrollToView(facetBrandApple);
			click(facetBrandApple);
			switchToCurrentWindow();
			wait(amazonLogo);
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Filter by 4 star rating
	 */
	public void filterByRating() {

		try {
//			System.out.println();
			scrollToView(amazonLogo);
			click(facetFourStar);
			switchToCurrentWindow();
			wait(amazonLogo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Sort by Price: High to Low
	 */
	public void sortByPriceDesc() {

		try {
			scrollToView(amazonLogo);
			click(sortByNew);
			click(sortPriceHighToLow);
			switchToCurrentWindow();
			wait(amazonLogo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Select laptop
	 */
	public void selectFirstLaptop() {
		// Click Laptop link at the top
		By searchResultsFirstLaptop = By
				.xpath("//span/div[contains(@class,'s-result-list s-search-results sg-row')]//h2/a/span");
		click(searchResultsFirstLaptop);
		switchToCurrentWindow();
	}

}
