package onboarding;

public class Problem3 {
	public static int solution(int number) {
		int answer = 0;
		answer = sumCounts(number);
		return answer;
	}

	private static int countSpecial(int number) {
		int count = 0;
		while (number > 0) {
			if ((number % 10) != 0 && (number % 10 % 3) == 0) {
				count += 1;
			}
			number /= 10;
		}
		return count;
	}

	public static int sumCounts(int number) {
		int count = 0;
		for (int i = 1; i <= number; i++) {
			count += countSpecial(i);
		}
		return count;
	}
}
