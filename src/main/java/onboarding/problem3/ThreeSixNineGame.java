package onboarding.problem3;

public class ThreeSixNineGame {

	public int getClapCount(int num) {
		return getClapCount(num, 0);
	}

	int getClapCount(int num, int count) {
		if (num <= 0) {
			return count;
		}
		if (is369(num % 10)) {
			count++;
		}
		return getClapCount(num / 10, count);
	}

	boolean is369(int num) {
		return num == 3 || num == 6 || num == 9;
	}
}
