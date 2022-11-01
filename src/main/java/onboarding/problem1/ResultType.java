package onboarding.problem1;

public enum ResultType {

	DRAW(0), POBI_WIN(1), CRONG_WIN(2), ERROR(-1);

	private int code;

	ResultType(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
}

