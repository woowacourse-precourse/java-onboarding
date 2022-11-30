package onboarding.enums.problem1;

public enum Output {
	EXCEPTION(-1),
	POBI_WIN(1),
	CRONG_WIN(2),
	DRAW(0);

	private int result;
	Output(int result){
		this.result = result;
	}

	public int getResult() {
		return result;
	}
}
