package onboarding;

public class Problem4 {
	public static final char LOWER_SRC = 'a';
	public static final char LOWER_DEST = 'z';
	public static final char UPPER_SRC = 'A';
	public static final char UPPER_DEST = 'Z';

	public static final String ERROR_MESSAGE = "제한 사항을 위배했습니다.";
	public static final int EXCEPTION = -1;

	public static String solution(String word) {
		int askiiSequence = 0; // 아스키코드 표 기준 앞에서부터 몇 번째 캐릭터인지
		char letter = ' ';

		if (checkRestrictions(word) == EXCEPTION) {
			return ERROR_MESSAGE;
		}

		return new String(conversionWord(word));
	}

	/**
	 * 주어진 문자열을 청개구리 사전대로 변환하는 메서드
	 * @param word
	 * @return
	 */
	private static char[] conversionWord(String word) {
		char[] letters = new char[word.length()];
		int askiiSequence;
		char letter;
		for (int i = 0; i < word.length(); i++) {
			letter = word.charAt(i);
			if (letter > LOWER_SRC && letter < LOWER_DEST) {
				letters[i] = (char)('a' + 'z' - letter); // 뒤에서부터 tmp 번째 캐릭터를 대입
			} else if (letter > UPPER_SRC && letter < UPPER_DEST) {
				letters[i] = (char)('A' + 'Z' - letter);
			} else {
				letters[i] = letter;
			}
		}
		return letters;
	}

	/**
	 * 제한사항을 위배했는지 체크하는 메서드
	 * @param word
	 * @return
	 */
	private static Integer checkRestrictions(String word) {
		if (!isNumberRangeValid(word)) {
			return EXCEPTION;
		}
		return 0;
	}

	// word 의 길이가 1 이상 1,000 이하가 아닌 경우 예외
	private static boolean isNumberRangeValid(String word) {
		if (word.length() < 1 || word.length() > 1000) {
			return false;
		}
		return true;
	}
}
