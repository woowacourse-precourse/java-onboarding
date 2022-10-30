package onboarding.problem1;

public enum PageInfo {
	LEFT(0),
	RIGHT(1),
	NEXT_INDEX(1),
	MIN_PAGES_COUNT(2),
	MIN_PAGE_INDEX(1),
	MAX_PAGE_INDEX(400);

	private int info;
	PageInfo(int info){
		this.info = info;
	}

	public int getInfo(){
		return this.info;
	}
}
