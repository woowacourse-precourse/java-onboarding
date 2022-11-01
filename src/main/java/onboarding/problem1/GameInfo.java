package onboarding.problem1;

public enum GameInfo {
	INVALID(-1),
	DRAW(0),
	POBI_WIN(1),
	CRONG_WIN(2);

	private int info;

	GameInfo(int info){
		this.info = info;
	}

	public int getInfo(){
		return this.info;
	}
}
