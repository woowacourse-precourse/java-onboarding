package onboarding;

public class Problem3 {
	private static final int NUMBER_OF_DIGIT_DIVISION = 10;
	private static final int[] CLAP_NUMBERS = new int[] {3, 6, 9};

	public static int solution(int number) {
		int answer = 0;
		for (int i = 0; i <= number; i++) {
			answer += isClap(i);
		}
		return answer;
	}

	private static int isClap(int number) {
		int clapCount = 0;
		while (number != 0) {
			for (int i = 0; i < CLAP_NUMBERS.length; i++) {
				if (number % NUMBER_OF_DIGIT_DIVISION == CLAP_NUMBERS[i]) {
					System.out.println(number);
					clapCount++;
				}
			}
			number /= NUMBER_OF_DIGIT_DIVISION;
		}
		return clapCount;
	}
}
