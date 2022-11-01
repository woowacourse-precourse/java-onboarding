package onboarding.problem4.util;

public class WordReverseInputVailidator {
	public static boolean lengthValidator(String word) {
		boolean result = word.length() >= 1 && word.length() <= 1_000;
		if (!result) throw new IllegalArgumentException("입력한 문자열의 길이는 1 이상 1,000 이하입니다.");
		return result;
	}
}
