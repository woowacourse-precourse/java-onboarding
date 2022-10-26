package onboarding;

import java.util.ArrayList;
import java.util.List;

public class PageNumberGame {
	List<Integer> pobi;
	List<Integer> crong;

	public PageNumberGame(List<Integer> pobi, List<Integer> crong) {
		this.pobi = pobi;
		this.crong = crong;
	}

	public void run() {
		int pobiScore = getScore(pobi);
		int crongScore = getScore(crong);

		System.out.println("pobiScore = " + pobiScore);
		System.out.println("crongScore = " + crongScore);
	}

	private int getScore(List<Integer> pages) {

		int left = pages.get(0);
		int right = pages.get(1);

		List<Integer> leftDigits = getDigit(left);
		List<Integer> rightDigits = getDigit(right);

		int leftScore = getValues(leftDigits);
		int rightScore = getValues(rightDigits);

		int score = Math.max(leftScore, rightScore);

		return score;
	}

	private List<Integer> getDigit(int number) {
		ArrayList<Integer> arrNum = new ArrayList<>();

		while (number > 0) {
			arrNum.add(number % 10);
			number /= 10;
		}

		return arrNum;
	}

	private int getValues(List<Integer> values) {
		int valueSum = 0;
		int valueMultiple = 1;

		for (int v : values) {
			valueSum += v;
			valueMultiple *= v;
		}

		int value = Math.max(valueSum, valueMultiple);

		return value;
	}
}
