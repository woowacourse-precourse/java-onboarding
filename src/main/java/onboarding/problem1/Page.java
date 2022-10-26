package onboarding.problem1;

public class Page {

	private final Digits pageNumber;

	public Page(int pageNumber) {
		this.pageNumber = new Digits(pageNumber);
	}

	public int calculateScore() {
		int multiplyScore = pageNumber.multiplyAllDigits();
		int addScore = pageNumber.addAllDigits();
		return Math.max(multiplyScore, addScore);
	}
}
