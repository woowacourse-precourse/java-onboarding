package onboarding;

public class ThreeSixNine {

	private final int number;
	private int clap = 0;

	public ThreeSixNine(int number) {
		this.number = number;
	}

	public int run() {
		for (int i = 1; i < number + 1; i++) {
			countClap(i);
		}
		return clap;
	}

	private void countClap(int number) {
		while (number > 0) {
			int digit = number % 10;
			if (is369(digit)) {
				clap += 1;
			}
			number /= 10;
		}
	}

	private boolean is369(int number) {
		return number == 3 || number == 6 || number == 9;
	}
}
