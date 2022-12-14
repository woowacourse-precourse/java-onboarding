package onboarding.enums.problem4;

public enum Index {
	INDEX_START(0),
	INDEX_END(26);

	private int index;

	Index(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}
}
