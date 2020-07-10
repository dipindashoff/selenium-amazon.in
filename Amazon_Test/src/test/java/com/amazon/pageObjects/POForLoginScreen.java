package com.amazon.pageObjects;

import org.openqa.selenium.By;

public interface POForLoginScreen {

	By amazonLogo = By.xpath("//a[contains(@class,'nav-logo-link')]");
	By accountsAndLists = By.xpath("//a[contains(@id,'nav-link-accountList')]");
	By username = By.id("ap_email");
	By continueButton = By.id("continue");
	By password = By.id("ap_password");
	By loginButton = By.id("signInSubmit");
	By searchBox = By.id("twotabsearchtextbox");
	
	
	

}
