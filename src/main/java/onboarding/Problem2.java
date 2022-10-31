package onboarding;

import onboarding.problem2.Decoder;

public class Problem2 {
	public static String solution(String cryptogram) {
		Decoder decoder = new Decoder();
		return decoder.decode(cryptogram);
	}
}
