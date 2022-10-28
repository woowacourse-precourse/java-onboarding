package onboarding;

public class Problem3 {
	public static int solution(int number) {
		int count = 0;
		int clapCount = 0;

		for (count = 1; count <= number; count++) {
			if (count % 10 == 3 || count % 10 == 6 || count % 10 == 9) {
				clapCount++;
			}
		}

		return clapCount;
	}
}
