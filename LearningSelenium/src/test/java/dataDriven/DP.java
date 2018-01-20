package dataDriven;

import org.testng.annotations.DataProvider;

public class DP {
	public static String[][] testData;
	
	@DataProvider(name = "fetchData")
	public static String[][] getData(){
		testData = new String[2][2];
		testData[0][0]="Rachit";
		testData[0][1]="RachitPwd";
		testData[1][0]="Prinu";
		testData[1][1]="PrinuPwd";
				
		return testData;
		
	}
}
