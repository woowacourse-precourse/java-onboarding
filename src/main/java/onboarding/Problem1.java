package onboarding;

import java.util.List;
import java.util.stream.Stream;

class Problem1 {


	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int answer = -1;

		if (validatePage(pobi, crong)) // 올바른 페이지일 경우
		{
			int[] leftNumsOfPobi = makeArrayOfNum(pobi.get(0));
			int[] rightNumsOfPobi = makeArrayOfNum(pobi.get(1)); // 포비의 왼쪽 오른쪽 배열 생성

			int[] leftNumsOfCrong = makeArrayOfNum(crong.get(0));
			int[] rightNumsOfCrong = makeArrayOfNum(crong.get(1)); // 크롱의 왼쪽 오른쪽 배열 생성

			int maxValueOfPobi = findMaxValue(leftNumsOfPobi, rightNumsOfPobi);
			int maxValueOfCrong = findMaxValue(leftNumsOfCrong, rightNumsOfCrong);

			answer = compareScore(maxValueOfPobi, maxValueOfCrong);

			return answer;
		}

		return answer;
	}


	/**
	 * 기능 1 각 자리 숫자를 배열로 만드는 기능
	 */
	public static int[] makeArrayOfNum(int num) {
		return Stream.of(String.valueOf(num).split("")).mapToInt(Integer::parseInt).toArray();
		// Int -> Stream<String> -> Stream<Integer> -> Array
	}

	/**
	 * 기능 2 왼쪽 페이지 숫자 배열과 오른쪽 페이지 숫자 배열이 주어졌을때, 최댓값을 구하는 기능
	 */

	public static int findMaxValue(int[] leftNum, int[] rightNum) {
		int maxValue = 0; // 각 자리 수를 더했을 때, 최솟값이 1이므로 0으로 초기화
		for (int i = 0; i < 2; i++) // 배열이 2개 이므로 2번반복
		{
			int addNum = 0; // 각 자리 수를 더할 변수
			int mulNum = 1; // 각 자리 수를 곱할 변수
			if (i == 0) {
				for (int j = 0; j < leftNum.length; j++) {
					addNum += leftNum[j];
					mulNum *= leftNum[j];
				}

				maxValue = Math.max(addNum, mulNum); // left 배열이 먼저 실행되므로 maxValue는 따로 비교하지 않아도 된다.
			}
			if (i == 1) {
				for (int j = 0; j < rightNum.length; j++) {
					addNum += rightNum[j];
					mulNum *= rightNum[j];
				}

				maxValue = Math.max(maxValue, Math.max(addNum, mulNum));
			}
		}

		return maxValue;
	}

	/**
	 * 기능 3 점수를 비교해 승자 값을 리턴하는 기능
	 */

	public static int compareScore(int scoreOfPobi, int scoreOfCrong) {
		if (scoreOfPobi > scoreOfCrong) {
			return 1; // 포비가 이기는 경우는 1
		}
		if (scoreOfCrong > scoreOfPobi) {
			return 2; // 크롱이 이기는 경우는 2
		}

		return 0; // 무승부인 경우는 0
	}

	/**
	 * 기능 4 페이지가 주어졌을 때, 예외사항을 판단하는 기능
	 */
	public static boolean validatePage(List<Integer> pobi, List<Integer> crong) {
		int leftPageOfPobi = pobi.get(0);
		int rightPageOfPobi = pobi.get(1);
		int leftPageOfCrong = crong.get(0);
		int rightPageOfCrong = crong.get(1);

		if (!leftPageOddValidation(leftPageOfPobi) || !leftPageOddValidation(leftPageOfCrong)) {
			return false;
		}
		if (!rightPageNumberValidation(leftPageOfPobi, rightPageOfPobi)
			|| !rightPageNumberValidation(leftPageOfCrong, rightPageOfCrong)) {
			return false;
		}
		if (!nullPageValidation(leftPageOfPobi, rightPageOfPobi)
			|| !nullPageValidation(leftPageOfCrong, rightPageOfCrong)) {
			return false;
		}

		return true;
	}

	/**
	 * 기능 5 왼쪽 페이지는 홀수만 올 수 있다.
	 */
	public static boolean leftPageOddValidation(Integer page) {
		if (page % 2 == 1) {
			return true;
		}

		return false;
	}

	/**
	 * 기능 6 오른쪽 페이지는 왼쪽 페이지 수의 1을 더한 것과 같아야한다.
	 */
	public static boolean rightPageNumberValidation(Integer leftPage, Integer rightPage) {
		if (leftPage + 1 == rightPage) {
			return true;
		}

		return false;
	}

	/**
	 * 기능 7 왼쪽 페이지와 오른쪽 페이지는 시작 면 또는 마지막 면이 될 수 없다.(시작 면과 마지막 면을 NULL로 생각함)
	 */
	public static boolean nullPageValidation(Integer leftPage, Integer rightPage) {
		if (leftPage != null || rightPage != null) {
			return true;
		}
		return false;
	}


}