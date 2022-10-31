package onboarding;

public class Problem2 {
	public static String solution(String cryptogram) {
		String answer = "answer";

		try {
			isValidCryptogram(cryptogram);
		} catch (IllegalStateException illegalStateException) {
			illegalStateException.printStackTrace();
			return answer;
		}

		answer = decodingCryptogram(cryptogram);

		return answer;
	}

	/**
	 * 1. 제한사항 확인
	 * @param cryptogram : 검사할 문자열
	 */
	public static void isValidCryptogram(String cryptogram) throws IllegalStateException {
		if (cryptogram.length() > 1000 || cryptogram.length() < 1)
			throw new IllegalStateException("문자열의 길이가 맞지 않습니다.");
		if (cryptogram.chars().allMatch(Character::isUpperCase))
			throw new IllegalStateException("문자열이 소문자로 이루어져있지 않습니다.");
	}

	/**
	 * 2. 중복 문자 제거
	 * @param cryptogram : 해독할 문자열
	 * @return 해독한 문자열
	 */
	public static String decodingCryptogram(String cryptogram) {
		String result = cryptogram;
		int index;
		do {
			index = result.length();
			result = removingChar(result);
		} while (result.length() != index);
		return result;
	}

	public static String removingChar(String cryptogram) {
		StringBuilder result = new StringBuilder();
		int index = 0;
		while (index < cryptogram.length()) {
			if (index == cryptogram.length() - 1) {
				result.append(cryptogram.charAt(index));
				break;
			}
			if (cryptogram.charAt(index) == cryptogram.charAt(index + 1)) {
				index += 2;
			} else {
				result.append(cryptogram.charAt(index));
				index++;
			}
		}
		return result.toString();
	}
}
