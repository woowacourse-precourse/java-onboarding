package onboarding;

import java.util.List;

public class SeparateDigit {
	int[] separatedNumber;
	int size;
	
	static final int MAXPAGE = 400;
	static final int MINPAGE = 1;
	public SeparateDigit(List<Integer> bookPage) {
		digitSeparating(bookPage);
	}
	public void digitSeparating(List<Integer> bookPage) {
		String stringNumber = bookPage.toString().replaceAll("[^0-9]", "");
		size = stringNumber.length();
		separatedNumber = new int[size];
		for (int i = 0; i < size; i++) {
			separatedNumber[i] = (int) stringNumber.charAt(i) - '0';
		}
	}
	public static boolean isWrongPage(List<Integer> bookPage) {
		int firstPage = bookPage.get(0);
		return (firstPage < MINPAGE || firstPage > MAXPAGE
				|| firstPage % 2 == 0
				|| firstPage - bookPage.get(1) != -1);
	}
	public int score() {
		int sum = sumSeparatedNumber();
		int mul = multiplySeparatedNumber();
		return Math.max(sum, mul);
	}
	public int sumSeparatedNumber() {
		int sum = 0;
		for (int i = 0; i < size; i++) {
			sum += separatedNumber[i];
		}
		return sum;
	}
	public int multiplySeparatedNumber() {
		int mul = 1;
		for (int i = 0; i < size; i++) {
			mul *= separatedNumber[i];
		}
		return mul;
	}
	public int compareScore(SeparateDigit otherDigit) {
		int myScore = this.score();
		int otherScore = otherDigit.score();
		int answer = -1;
		if (myScore > otherScore) {
			answer = 1;
			return answer;
		}
		if (myScore == otherScore) {
			answer = 0;
			return answer;
		}
		if (myScore < otherScore) {
			answer = 2;
			return answer;
		}
		return answer;
	}
}
