package onboarding;

import onboarding.crytogramDecoding.CryptogramDecoding;

public class Problem2 {
	public static String solution(String cryptogram) {
		CryptogramDecoding cryptoObject = new CryptogramDecoding();
		cryptoObject.decode(cryptogram);
		String answer = "";
		return answer;
	}

	public static void main(String[] args) {
		String result;
		result = solution("browoanoommnaon");
		System.out.println(result);
	}
}
