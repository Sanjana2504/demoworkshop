package com.qa.demoshop.dataproviders;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.qa.demoshop.applicationconstants.DataHandlingConstants;
import com.qa.demoshop.utilities.ReadExcelUtility;

public class RegisterDataProvider {

	@DataProvider(name="registerdata")
	public String[][] getRegisterData() throws IOException{
		int lastRow=ReadExcelUtility.getLastRowNumber(DataHandlingConstants.RegisterUserExcelPath,DataHandlingConstants.RegisterSheetname);
		int lastCell=ReadExcelUtility.getLastCellNumber(DataHandlingConstants.RegisterUserExcelPath,DataHandlingConstants.RegisterSheetname,0);
		
		String[][] values=new String[lastRow + 1][lastCell];
		
		for(int r=0;r<=lastRow;r++)
		{
			for(int c=0;c<lastCell;c++)
			{
				values[r][c]=ReadExcelUtility.getData(DataHandlingConstants.RegisterUserExcelPath,DataHandlingConstants.RegisterSheetname, r, c);
				System.out.println(ReadExcelUtility.getData(DataHandlingConstants.RegisterUserExcelPath,DataHandlingConstants.RegisterSheetname, r, c));
			}
		}
		return values;
	}
		
}
/*	@DataProvider(name="productdata")
		
			public String[][] getProductData() throws IOException
			{
		int lastRow=ReadExcelUtility.getLastRowNumber(DataHandlingConstants.RegisterUserExcelPath,DataHandlingConstants.RegisterSheetname);
		int lastCell=ReadExcelUtility.getLastCellNumber(DataHandlingConstants.RegisterUserExcelPath,DataHandlingConstants.RegisterSheetname,0);
		return null;
				
			}
		}
		*/


