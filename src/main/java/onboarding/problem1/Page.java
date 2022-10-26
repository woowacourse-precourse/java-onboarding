package onboarding.problem1;

public class Page {

	private final Digits pageNumber;

	public Page(int pageNumber) {
		validateNotStart(pageNumber);
		validateNotEnd(pageNumber);
		this.pageNumber = new Digits(pageNumber);
	}

	public int calculateScore() {
		int multiplyScore = pageNumber.multiplyAllDigits();
		int addScore = pageNumber.addAllDigits();
		return Math.max(multiplyScore, addScore);
	}

	private void validateNotStart(int pageNumber) {
		if (pageNumber <= 0) {
			throw new IllegalArgumentException("페이지는 시작면보다 커야합니다");
		}
	}

	private void validateNotEnd(int pageNumber) {
		if (pageNumber > 400) {
			throw new IllegalArgumentException("페이지는 마지막면보다 작아야합니다");
		}
	}
}
