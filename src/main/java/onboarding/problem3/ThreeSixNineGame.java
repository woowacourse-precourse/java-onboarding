package onboarding.problem3;

public class ThreeSixNineGame {

	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 10000;
	private final int inputNumber;

	public ThreeSixNineGame(int inputNumber) {
		validateInputNumber(inputNumber);
		this.inputNumber = inputNumber;
	}

	private void validateInputNumber(int inputNumber) {
		if (inputNumber < MIN_NUMBER || inputNumber > MAX_NUMBER) {
			throw new IllegalArgumentException("입력값은 1~10,000의 자연수 입니다.");
		}
	}

	public int getResult() {
		int result = 0;
		for (int i = MIN_NUMBER; i <= inputNumber; i++) {
			result += getClapCount(i);
		}
		return result;
	}

	int getClapCount(int num) {
		return getClapCount(num, 0);
	}

	int getClapCount(int num, int count) {
		if (num <= 0) {
			return count;
		}
		if (is369(num % 10)) {
			count++;
		}
		return getClapCount(num / 10, count);
	}

	boolean is369(int num) {
		return num == 3 || num == 6 || num == 9;
	}
}
