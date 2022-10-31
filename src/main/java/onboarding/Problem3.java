package onboarding;

public class Problem3 {
	public static int solution(int number) {
		int answer = 0;
		for (int i = 1; i <= number; i++) {
			answer += countClap(i);
		}
		return answer;
	}

	private static int countClap(int num) {
		int count = 0;
		while (num > 0) {
			int digit = (num % 10);
			if (digit != 0 && digit % 3 == 0) {
				count++;
			}
			num /= 10;
		}
		return count;
	}
}
