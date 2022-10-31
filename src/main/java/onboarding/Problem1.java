package onboarding;

import java.util.List;

class Problem1 {

	static final int EXCEPTION_CASE = -1;
	static final int DRAW_CASE = 0;
	static final int POBI_CASE = 1;
	static final int CRONG_CASE = 2;
	static final int FIRST_PAGE = 1;
	static final int LAST_PAGE = 400;

	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int answer = Integer.MAX_VALUE;

		// 값 검증
		if (validateNum(pobi) == -1 || validateNum(crong) == -1)
			return EXCEPTION_CASE;

		// 포비와 크롱의 점수 구하기
		int pobiScore = getScore(pobi);
		int crongScore = getScore(crong);

		// 승자 구하기
		answer = getWinner(pobiScore, crongScore);

		return answer;
	}

	// 올바르면 1, 이상하면 -1을 return
	private static int validateNum(List<Integer> lst) {
		if (lst.get(0) < FIRST_PAGE || lst.get(1) > LAST_PAGE)
			return EXCEPTION_CASE;
		if (lst.get(0) % 2 == 0 || lst.get(1) % 2 == 1)
			return EXCEPTION_CASE;
		if (lst.get(0) + 1 != lst.get(1))
			return EXCEPTION_CASE;

		return 1;
	}

	private static int getScore(List<Integer> lst) {
		int leftScore = 0;
		int rightScore = 0;

		leftScore = Math.max(addDigit(lst.get(0)), multiplyDigit(lst.get(0)));
		rightScore = Math.max(addDigit(lst.get(1)), multiplyDigit(lst.get(1)));

		int score = Math.max(leftScore, rightScore);

		return score;
	}

	private static int addDigit(int num) {
		int sum = 0;
		String[] arr = String.valueOf(num).split("");
		int[] numbers = new int[arr.length];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(arr[i]);
		}

		for (int k = 0; k < numbers.length; k++) {
			sum += numbers[k];
		}
		return sum;

	}

	private static int multiplyDigit(int num) {
		int sum = 1;

		String[] arr = String.valueOf(num).split("");
		int[] numbers = new int[arr.length];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(arr[i]);
		}

		for (int k = 0; k < numbers.length; k++) {
			sum *= numbers[k];
		}
		return sum;

	}

	private static int getWinner(int num1, int num2) {
		if (num1 > num2)
			return POBI_CASE;
		if (num1 < num2)
			return CRONG_CASE;

		return DRAW_CASE;
	}
}