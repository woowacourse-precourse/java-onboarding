package onboarding;

public class Problem4 {
	public static final int PRE_a_IN_ASCII_TABLE = 96;
	public static final int NEXT_z_IN_ASCII_TABLE = 123;
	public static final int PRE_A_IN_ASCII_TABLE = 64;
	public static final int NEXT_Z_IN_ASCII_TABLE = 91;

	public static final String ERROR_MESSAGE = "제한 사항을 위배했습니다.";
	public static final int EXCEPTION = -1;

	public static String solution(String word) {
		char[] charArr = new char[word.length()];
		int askiiSequence = 0; // 아스키코드 표 기준 앞에서부터 몇 번째 캐릭터인지
		char letter = ' ';

		if (checkRestrictions(word) == EXCEPTION) {
			return ERROR_MESSAGE;
		}

		for (int i = 0; i < word.length(); i++) {
			letter = word.charAt(i);
			if (letter > 'a' && letter < 'z') {
				askiiSequence = letter - PRE_a_IN_ASCII_TABLE;
				charArr[i] = (char)(NEXT_z_IN_ASCII_TABLE - askiiSequence); // 뒤에서부터 tmp 번째 캐릭터를 대입
			} else if (letter > 'A' && letter < 'Z') {
				askiiSequence = letter - PRE_A_IN_ASCII_TABLE;
				charArr[i] = (char)(NEXT_Z_IN_ASCII_TABLE - askiiSequence);
			} else {
				charArr[i] = letter;
			}
		}

		return new String(charArr);
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
