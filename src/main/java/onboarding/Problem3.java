package onboarding;

public class Problem3 {

	private static int clap;

	public static int solution(int number) {
		clap = 0;
		for (int i = 1; i < number + 1; i++) {
			countClap(i);
		}
		return clap;
	}

	private static void countClap(int number) {
		while (number > 0) {
			int digit = number % 10;
			if (is369(digit)) {
				clap += 1;
			}
			number /= 10;
		}
	}

	private static boolean is369(int number) {
		return number == 3 || number == 6 || number == 9;
	}
}
