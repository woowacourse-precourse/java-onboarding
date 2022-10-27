package onboarding;

import onboarding.crytogramDecoding.CryptogramDecoding;

public class Problem2 {
	public static String solution(String cryptogram) {
		CryptogramDecoding cryptoObject = new CryptogramDecoding();
		return cryptoObject.decode(cryptogram);
	}
}
