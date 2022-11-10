package ehr_favorite;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry_Analyser implements IRetryAnalyzer {
	int failedcount = 0;
	int limit = 4;
	boolean cnd = false;

	public boolean retry(ITestResult result) {

		if (failedcount <= 4) {
			failedcount++;
			return cnd = true;
		} else {
			return cnd = false;
		}

	}

}
