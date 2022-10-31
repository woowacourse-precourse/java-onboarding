package onboarding.problemthree.domain;

public class Game {

	private int number;

	public Game(int number) {
		this.number = number;
	}

	public int play() {
		int cnt = 0;

		for (int i = 1; i <= number; i++) {
			cnt += countClap(i);
		}
		return cnt;
	}

	private int countClap(int num) {
		int cnt = 0;
		int digit;

		while (num >= 10) {
			digit = num % 10;
			if (digit == 3 || digit == 6 || digit == 9) {
				cnt += 1;
			}
			num /= 10;
		}
		if (num == 3 || num == 6 || num == 9) {
			cnt += 1;
		}

		return cnt;
	}
}
