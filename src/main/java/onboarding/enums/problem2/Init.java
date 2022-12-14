package onboarding.enums.problem2;

public enum Init {
	INIT_SAME_LETTER_COUNT("1"),
	INIT_INDEX("-1"),
	INIT_ANSWER("");

	private String initialValue;

	Init(String initialValue){
		this.initialValue = initialValue;
	}

	public String getInitialValue() {
		return initialValue;
	}

	public int getInitialValueNumber() {
		return Integer.parseInt(initialValue);
	}
}
