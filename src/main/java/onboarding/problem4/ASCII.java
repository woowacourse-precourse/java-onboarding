package onboarding.problem4;

public enum ASCII {
	COMMON_INDEX_OFFSET(25),
	UPPER_CASE_START_INDEX(65),
	LOWER_CASE_START_INDEX(97);

	private int value;

	ASCII(int value){
		this.value = value;
	}

	public int getValue(){
		return this.value;
	}

}
