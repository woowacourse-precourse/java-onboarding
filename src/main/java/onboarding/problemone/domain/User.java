package onboarding.problemone.domain;

import java.util.List;

public class User {

	private int leftPage;
	private int rightPage;

	private int score;

	public User(List<Integer> pages){

		this.leftPage=pages.get(0);
		this.rightPage=pages.get(1);
	}

	public void calculateScore(){
		int leftMax = calCulateMax(this.leftPage);
		int rightMax = calCulateMax(this.rightPage);

		this.score = leftMax > rightMax ? leftMax : rightMax;
	}

	public int calCulateMax(int num){
		int sum=0;
		int mul=1;

		do{
			int digit = num%10;
			sum+=digit;
			mul*=digit;
			num/=10;
		} while(num>=10);

		return sum>mul ? sum : mul;
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
