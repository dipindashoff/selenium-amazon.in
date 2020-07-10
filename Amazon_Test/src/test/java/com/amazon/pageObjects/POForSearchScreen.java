package com.amazon.pageObjects;

import org.openqa.selenium.By;

public interface POForSearchScreen {

	// Search screen
	By hamburgerIcon = By.xpath("//a[@id='nav-hamburger-menu']/i");
	By menuMobilesLaptops = By.xpath("//li/a/div[normalize-space(text())='Mobiles, Computers']");
	By menuLaptops = By.xpath("//li/a/div[normalize-space(text())='Laptops']");
	By headerLaptops = By.xpath("//h1[text()='Laptops']");

	By facetBrandApple = By.xpath("//span[text()='Apple']//preceding-sibling::label/input");
	By facetFourStar = By.xpath("//span[text()='4 Stars & Up']/parent::i");
	By sortByButton = By.xpath("//span[starts-with(text(),'Sort']");
	By sortByNew = By.xpath("//span[text()='New & Popular']");
	By sortPriceHighToLow = By.xpath("//a[text()='Price: High to Low']");
	By searchResultsFirstLaptop = By
			.xpath("//span/div[contains(@class,'s-result-list s-search-results sg-row')]//h2/a/span");
	
	//TODO
	By amazonLogo = By.xpath("//a[contains(@class,'nav-logo-link')]");

}
