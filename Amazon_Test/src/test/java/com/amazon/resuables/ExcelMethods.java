package com.amazon.resuables;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;

public class ExcelMethods {

	/**
	 * Write to excel
	 */
	public void writeToExcel(String str) {

		try {
			Fillo fillo = new Fillo();
			Connection connection = fillo.getConnection(".\\Output.xlsx");

			String strQuery = "Update Sheet1 Set Spec='"+str+"'";

			connection.executeUpdate(strQuery);

			connection.close();
		} catch (FilloException e) {
			e.printStackTrace();
		}

	}
	
	

}
