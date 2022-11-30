package onboarding.enums.problem1;

public enum InitNumber {
	INIT_ONE(1),
	INIT_ZERO(0);

	private int number;

	InitNumber(int number){
		this.number = number;
	}

	public int getNumber() {
		return number;
	}
}
