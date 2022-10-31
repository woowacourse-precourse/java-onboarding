package onboarding;

public class Problem3 {
	private static int isIn369(int val) {
		if (val == 3 || val == 6 || val == 9)
			return (1);
		return (0);
	}
	private static int checkCurrentNumber(int current) {
		int count = 0;
		int remainder = current;

		while (remainder > 0) {
			count += isIn369(remainder % 10);
			remainder /= 10;
		}
		return (count);
	}
	public static int solution(int number) {
		int ret = 0;

		for (int i = 0; i <= number; i++) {
			ret += checkCurrentNumber(i);
		}
		return (ret);
	}
}
