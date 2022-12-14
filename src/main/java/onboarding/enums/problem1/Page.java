package onboarding.enums.problem1;

public enum Page {
	LEFT_PAGE(0),
	RIGHT_PAGE(1),
	MIN_PAGE(1),
	MAX_PAGE(400),
	PAGE_INTERVAL(1);

	private int page;
	Page(int page){
		this.page = page;
	}

	public int getPage() {
		return page;
	}
}
