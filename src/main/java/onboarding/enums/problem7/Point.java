package onboarding.enums.problem7;

public enum Point {
	FRIEND_POINT(20),
	ZERO_POINT(0),
	ONE_POINT(1);

	private int number;

	Point(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}
}
