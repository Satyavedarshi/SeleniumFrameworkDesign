package shoppingsite.testcomponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryTest implements IRetryAnalyzer{
	
	int count = 0;
	int maxTry = 2;

	@Override
	public boolean retry(ITestResult arg0) {
		// TODO Auto-generated method stub
		if(count<maxTry) {
			count++;
			return true;
		}
		return false;
	}

}
