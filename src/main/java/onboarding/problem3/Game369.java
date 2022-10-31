package onboarding.problem3;

public class Game369 {

	private final int MAX_NUMBER_PLUS_ONE = 10001;
	private final int[] countList = new int[MAX_NUMBER_PLUS_ONE];
	public Game369() {
		Number369Counter number369Counter = new Number369Counter();
		for (int i = 1; i < MAX_NUMBER_PLUS_ONE; i++) {
			countList[i] = countList[i - 1] + number369Counter.getFirstCount(i);
		}
	}

	public int getCount(int number) {
		return countList[number];
	}
}
