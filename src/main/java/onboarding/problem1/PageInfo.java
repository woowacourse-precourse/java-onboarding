package onboarding.problem1;

public enum PageInfo {
	LEFT(0),
	RIGHT(1),
	NEXT_INDEX(1),
	MIN_PAGES(2);

	private int info;
	PageInfo(int info){
		this.info = info;
	}

	public int getInfo(){
		return this.info;
	}
}
