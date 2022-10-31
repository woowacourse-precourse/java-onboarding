package onboarding;

public class Problem3 {
	public static int solution(int number) {
		return sumTotalClap(number);
	}

	private static int sumTotalClap(int number) {
		int totalCount = 0;
		for (int i = 1; i <= number; i++) {
			totalCount += countClap(i);
		}
		return totalCount;
	}

	private static int countClap(int i) {
		int count = 0;
		while (i != 0) {
			if (i % 10 == 3 || i % 10 == 6 || i % 10 == 9) {
				count += 1;
			}
			i /= 10;
		}
		return count;
	}
}
