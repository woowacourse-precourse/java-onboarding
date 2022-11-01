package onboarding;

public class Problem3 {

	public static final String PLEASE_ENTER_RIGHT_NUMBER = "범위 내의 숫자를 입력해주세요";
	public static final int MIN = 1;
	public static final int MAX = 10000;
	public static final int INITIAL_CLAP = 0;
	public static final char THREE = '3';
	public static final char SIX = '6';
	public static final char NINE = '9';
	public static final int CLAP = 1;
	public static final int SKIP = 0;

	public static int solution(int number) {
		validateNumber(number);

		return calculateClap(number);
	}

	private static void validateNumber(int number) {
		if (number < MIN || number > MAX) {
			throw new IllegalArgumentException(PLEASE_ENTER_RIGHT_NUMBER);
		}
	}

	private static int calculateClap(int number) {
		int clap = INITIAL_CLAP;
		for (int i = 1; i <= number; i++) {
			String currentNum = String.valueOf(i);
			clap += getClap(currentNum);
		}
		return clap;
	}

	private static int getClap(String currentNum) {
		int clap = INITIAL_CLAP;
		for (int j = 0; j < currentNum.length(); j++) {
			char digit = currentNum.charAt(j);
			clap += increaseClapCount(digit);
		}

		return clap;
	}

	private static int increaseClapCount(char digit) {
		if (digit == THREE || digit == SIX || digit == NINE) {
			return CLAP;
		}
		return SKIP;
	}
}
