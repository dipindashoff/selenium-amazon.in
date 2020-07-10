package com.amazon.pageActions;

import com.amazon.pageObjects.POForLoginScreen;
import com.amazon.resuables.CommonMethods;

public class LoginScreen extends CommonMethods implements POForLoginScreen {

	/**
	 * Sign in to Amazon.in
	 */
	public void signIn() {

		wait(amazonLogo);
		// Go to Sing In page
		click(accountsAndLists);
		switchToCurrentWindow();
		wait(username);
		// Enter username
		enterText(username, getProperty("username"));
		// continue
		click(continueButton);
		// Enter password
		enterText(password, getProperty("password"));
		// Sign In
		click(loginButton);
		switchToCurrentWindow();
		wait(searchBox);

	}

}
