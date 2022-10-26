package onboarding;

public class ThreeSixNine {

	private final int number;

	public ThreeSixNine(int number) {
		this.number = number;
	}

	public int run() {
		for (int i = 1; i < number + 1; i++) {
			countClap(i);
		}
		return 0;
	}

	private void countClap(int number) {
		while (number > 0) {
			int digit = number % 10;
			number /= 10;
		}
	}
}
