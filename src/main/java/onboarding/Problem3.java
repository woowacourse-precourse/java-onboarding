package onboarding;

public class Problem3 {
	public static int solution(int number) {
		int answer = 0;
		for (int i = 1; i <= number; i++) {
			answer += get369(i);
		}
		return answer;
	}

	public static int get369(int number) {
		int result = 0;
		while (number > 0) {
			int temp = number % 10;
			if (temp != 0 && temp % 3 == 0) {
				result++;
			}
			number /= 10;
		}
		return result;
	}
}
