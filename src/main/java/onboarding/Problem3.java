package onboarding;

public class Problem3 {
	public static int solution(int number) {
		int totalClapCount = 0;
		for (int count = 1; count <= number; count++) {
			totalClapCount += getClapCount(count);
		}
		return totalClapCount;
	}

	private static int getClapCount(int number) {
		int clapCount = 0;
		while (number > 0) {
			if (number % 10 == 3 || number % 10 == 6 || number % 10 == 9) {
				clapCount++;
			}
			number /= 10;
		}
		return clapCount;
	}

}
