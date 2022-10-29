package onboarding;

public class Problem2 {
	public static String solution(String cryptogram) {
		String answer = "answer";

		try {
			isValidCryptogram(cryptogram);
		} catch (IllegalStateException illegalStateException) {
			illegalStateException.printStackTrace();
		}

		return answer;
	}

	/**
	 * 1. 제한사항 확인
	 * @param cryptogram : 검사할 문자열
	 * @return 문자열의 유효 여부
	 */
	public static void isValidCryptogram(String cryptogram) throws IllegalStateException {
		if (cryptogram.length() > 1000 || cryptogram.length() < 1)
			throw new IllegalStateException("문자열의 길이가 맞지 않습니다.");
		if (cryptogram.chars().allMatch(Character::isUpperCase))
			throw new IllegalStateException("문자열이 소문자로 이루어져있지 않습니다.");
	}
}
