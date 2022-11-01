package onboarding;

public class Problem4 {
	public static String solution(String word) {
		String answer = "answer";

		try {
			isValidWord(word);
		} catch (IllegalStateException illegalStateException) {
			illegalStateException.printStackTrace();
			return answer;
		}

		answer = applyTreeFrogDict(word);

		return answer;
	}

	/**
	 * 1. 제한사항 확인
	 * @param word : 검사할 문자열
	 * @throws IllegalStateException : 문자열의 길이가 1~1000 범위 밖인 경우 예외처리
	 */
	public static void isValidWord(String word) throws IllegalStateException {
		if (word.length() < 1 || word.length() > 1000) {
			throw new IllegalStateException("word의 길이가 올바르지 않습니다.");
		}
	}

	/**
	 * 2. 청개구리 사전 적용
	 * @param word : 사전 적용할 문자열
	 * @return : 사전 적용 후 변경된 문자열
	 */
	public static String applyTreeFrogDict(String word) {
		StringBuilder result = new StringBuilder();
		word.chars().map(Problem4::treeFrogDict).forEach(chars -> result.append((char)chars));
		return result.toString();
	}

	public static int treeFrogDict(int c) {
		if (c == ' ')
			return c;
		if (c >= 'a') {
			return 'z' - (c - 'a');
		} else {
			return 'Z' - (c - 'A');
		}
	}
}
