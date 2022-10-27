package onboarding;

import onboarding.problem2.CheckCrytogram;
import onboarding.problem2.Cryptogram;

public class Problem2 {
	public static String solution(String cryptogram) {
		if (!CheckCrytogram.of(cryptogram)) {
			throw new IllegalArgumentException("cyptogram은 모두 소문자여야 합니다.(a~z)");
		}
		return Cryptogram.getRightAnswer(cryptogram);
	}
}
