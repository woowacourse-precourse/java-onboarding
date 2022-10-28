package onboarding;

import onboarding.problem2.CryptogramDecoding;

public class Problem2 {
	public static String solution(String cryptogram) {
		CryptogramDecoding cryptoObject = new CryptogramDecoding();
		return cryptoObject.decode(cryptogram);
	}
}
