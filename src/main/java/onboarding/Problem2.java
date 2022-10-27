package onboarding;

import onboarding.problem2.CheckCrytogram;
import onboarding.problem2.Cryptogram;

public class Problem2 {
	public static String solution(String cryptogram) {
		if (!CheckCrytogram.of(cryptogram)) {
			throw new IllegalArgumentException("cryptogram이 정확하지 않습니다.");
		}
		return Cryptogram.getRightAnswer(cryptogram);
	}
}
