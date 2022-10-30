package onboarding;

public class Problem3 {

	public static int solution(int number) {
		return Game.countClapsUpTo(number);
	}

	public static class Game {

		public static int countClapsUpTo(int number) {
			int count = 0;
			for (int i = 3; i <= number; i++) {
				count += countClaps(i);
			}
			return count;
		}

		public static int countClaps(int number) {
			int count = 0;
			while (number != 0) {
				final int units = number % 10;
				if (units != 0 && units % 3 == 0) {
					count++;
				}
				number /= 10;
			}
			return count;
		}

	}

}
