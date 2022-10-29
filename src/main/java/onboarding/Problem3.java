package onboarding;

public class Problem3 {
	public static int solution(int number) {
		int answer = 0;
		for (int i = 1; i <= number; i++) {
			answer += countingClaps(i);
		}
		return answer;
	}
	public static int countingClaps(int n) {
		int count = 0;
		int number = n;
		while (number > 0) {
			if ((number % 10) != 0 && (number % 10) % 3 == 0) {
				count++;
			}
			number /= 10;
		}
		return count;
	}
}
