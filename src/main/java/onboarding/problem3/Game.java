package onboarding.problem3;

public class Game {

	private final int endNumber;

	public Game(int endNumber) {
		this.endNumber = endNumber;
	}

	public int countClaps() {
		int count = 0;
		for (int i = 1; i <= endNumber; i++) {
			Digits digits = new Digits(i);
			count += digits.countThreeSixNine();
		}
		return count;
	}
}
