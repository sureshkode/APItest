package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name = "Data")
	public String[][] getalldata() throws IOException {

		String path = "C:\\RW_APPS\\RestAssuredAPITesting\\testdata\\"+"userdata.xlsx";
		//String path = System.getProperty("user.dir")+ "userdata.xlsx";
		
		XLUtility xl= new XLUtility(path);
		int rownum = xl.getRowCount("Sheet1");
		int celnum = xl.getCellCount("Sheet1", 1);

		String apidata[][] = new String[rownum][celnum];

		for (int i = 0; i < rownum; i++) {
			for (int j = 0; j < rownum; j++) {
				apidata[i - 1][j] = xl.getCellData("Sheet1", i, j);
			}
		}

		return apidata;

	}

	@DataProvider(name = "UserNames")
	public String[] getUserNames() throws IOException {
		String path = System.getProperty("user.dir") + "userdata.xlsx";

	 XLUtility xl =new XLUtility(path);

		int rownum = xl.getRowCount("Sheet1");

		String[] apidata = new String[rownum];

		for (int i = 0; i < rownum; i++) {

			apidata[i - 1] = xl.getCellData("Sheet1", i, 1);

		}

		return apidata;

	}

}
