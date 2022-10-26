package onboarding;

public class Problem3 {
	private static int count369(int number) {
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

	public static int solution(int number) {
		int answer = 0;
		return answer;
	}
}
