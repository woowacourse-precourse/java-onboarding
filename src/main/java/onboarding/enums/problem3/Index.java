package onboarding.enums.problem3;

public enum Index {
	MEMOIZATION_START_INDEX(3),
	LETTER_START_INDEX(0);

	private int number;
	Index(int number){
		this.number = number;
	}

	public int getNumber() {
		return number;
	}
}
