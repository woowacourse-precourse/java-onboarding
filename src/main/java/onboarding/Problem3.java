package onboarding;

public class Problem3 {
	public static int solution(int number) {
		int answer = 0;
		for (int i = 1; i <= number; i++) {
			answer += countClabs(i);
		}
		return answer;
	}

	private static int countClabs(int number) {
		int count = 0;
		while (number > 0) {
			int units = number % 10;
			if (units % 3 == 0 && units != 0) {
				count += 1;
			}
			number /= 10;
		}
		return count;
	}
}
