package onboarding.problem1;

public class Digit {

	private final int digit;

	public Digit(int digit) {
		this.digit = digit;
	}

	public Digit add(Digit digit) {
		return new Digit(this.digit + digit.value());
	}

	public Digit multiply(Digit digit) {
		return new Digit(this.digit * digit.value());
	}

	public int value() {
		return digit;
	}
}
