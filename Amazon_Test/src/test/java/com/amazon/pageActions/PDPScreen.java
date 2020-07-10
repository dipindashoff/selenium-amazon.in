package com.amazon.pageActions;

import com.amazon.pageObjects.POForPDPScreen;
import com.amazon.resuables.CommonMethods;

public class PDPScreen extends CommonMethods implements POForPDPScreen {

	/**
	 * Search screen
	 */
	public void copySpec() {

		try {
			// Wait for the screen
			wait(addToCartButton);

			// Scroll to view spec
			scrollToView(specText);

			// copy to notepad
			copyToNotepad(getText(specText));

			// Click Add to cart
			click(addToCartButton);
			
			// Take screenshot
			takeScreenshot();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
