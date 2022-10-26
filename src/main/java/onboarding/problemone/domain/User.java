package onboarding.problemone.domain;

import java.util.List;

public class User {

	private int leftPage;
	private int rightPage;


	public User(List<Integer> pages){

		this.leftPage=pages.get(0);
		this.rightPage=pages.get(1);
	}

	public int getLeftPage() {
		return leftPage;
	}

	public void setLeftPage(int leftPage) {
		this.leftPage = leftPage;
	}

	public int getRightPage() {
		return rightPage;
	}

	public void setRightPage(int rightPage) {
		this.rightPage = rightPage;
	}
}
