package onboarding;

public class Problem3 {
    public static int solution(int number) {
		if (!isValidNumber(number)) {
			return -1;
		}

        return answer;
    }
	private static boolean isValidNumber(int number) {
		return number >= 1 && number <= 1000;
	}

	private static int countClap(int number) {
		int result = 0;

		int[] numberList = Stream.of(String.valueOf(number).split("")).mapToInt(Integer::parseInt).toArray();

		for (int n : numberList) {
			if (n == 3 || n == 6 || n == 9) {
				result++;
			}
		}
		return result;
	}
}
