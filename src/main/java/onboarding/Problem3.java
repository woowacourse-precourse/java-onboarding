package onboarding;

public class Problem3 {
	private static int count(int num) {
		int count = 0;
		int rest;
		while (true) {
			rest = num % 10;
			if (rest == 3 || rest == 6 || rest == 9)
				count += 1;
			if (num / 10 == 0)
				break;
			num = num / 10;
		}
		return (count);
	}

	public static int solution(int number) {
		int answer = 0;
		for (int num = 1; num <= number; num++) {
			answer += count(num);
		}
		return answer;
	}
}
