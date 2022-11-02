package onboarding;

import java.util.List;

import onboarding.problem1.Pages;

class Problem1 {

	public static final int RESULT_EXCEPTIONAL = -1;

	private enum RESULT {
		DRAW(0), POBI(1), CRONG(2);

		private final int number;

		RESULT(int number) {
			this.number = number;
		}

		public int number() {
			return number;
		}

		private static RESULT from(int pobiScore, int crongScore) {
			if (pobiScore > crongScore) {
				return RESULT.POBI;
			}
			if (pobiScore < crongScore) {
				return RESULT.CRONG;
			}
			return RESULT.DRAW;
		}
	}

	public static int solution(List<Integer> pobi, List<Integer> crong) {
		try {
			int pobiScore = new Pages(pobi).calculateScore();
			int crongScore = new Pages(crong).calculateScore();

			return RESULT.from(pobiScore, crongScore).number();
		} catch (IllegalArgumentException exception) {
			System.err.println(exception.getMessage());
			return RESULT_EXCEPTIONAL;
		}
	}
}