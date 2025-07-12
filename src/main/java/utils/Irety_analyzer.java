package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Irety_analyzer implements IRetryAnalyzer {

	int inital_count=0;
	int retry_count=2;
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if (inital_count<retry_count) {
			
			inital_count++;
			return true;
			
		}
		return false;
	}


}
