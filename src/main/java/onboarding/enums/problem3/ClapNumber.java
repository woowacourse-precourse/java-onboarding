package onboarding.enums.problem3;

public enum ClapNumber {
	THREE("3"),
	SIX("6"),
	NINE("9");

	private String specialNumber;
	ClapNumber(String specialNumber){
		this.specialNumber = specialNumber;
	}

	public String getSpecialNumber() {
		return specialNumber;
	}
}
