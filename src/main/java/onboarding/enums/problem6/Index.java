package onboarding.enums.problem6;

public enum Index {
	START_INDEX(0),
	EMAIL_INDEX(0),
	NICKNAME_INDEX(1);

	private int index;

	Index(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}
}
