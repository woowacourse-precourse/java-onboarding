package onboarding.enums.problem4;

public enum AlphabetAscii {
	A(65),
	Z(90),
	a(97),
	z(122);

	private int number;

	AlphabetAscii(int number){
		this.number = number;
	}

	public int getNumber() {
		return number;
	}
}
