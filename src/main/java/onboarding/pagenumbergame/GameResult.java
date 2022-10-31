package onboarding.pagenumbergame;

public enum GameResult {
	EXCEPTION(-1),
	DRAW(0),
	WIN(1),
	LOSE(2);

	private final int status;

	GameResult(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}
}
