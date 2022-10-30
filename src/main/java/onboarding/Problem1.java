package onboarding;

import java.util.List;

/**
 * 
 * 기능 목록 1) checkStartOrLast 2) checkWrongPage 3) maxPobiNumber 4)
 * maxCrongNumber 5) whoWin 6) sum 7) multiply
 * 
 * @version java 11 2022년 10월 27일
 * @author 이규호(tlqkrus012345)
 *
 */
class Problem1 {

	static int answer = Integer.MAX_VALUE;

	public static int solution(List<Integer> pobi, List<Integer> crong) {

		if (checkWrongPage(pobi, crong)) {
			answer = -1;
		}

		if (!checkStartOrLast(pobi, crong) && !checkWrongPage(pobi, crong)) {
			int pobiMaxNumber = maxPobiNumber(pobi);
			int crongMaxNumber = maxCrongNumber(crong);
			answer = whoWin(pobiMaxNumber, crongMaxNumber);
		}

		return answer;
	}

	/**
	 * 두 개의 인자 값이 시작 면과 마지막 면인지 확인하는 기능이다.
	 * 
	 * @param pobi
	 * @param crong
	 * @return 시작 면과 마지막 면이면 true 그 외는 false
	 */
	public static boolean checkStartOrLast(List<Integer> pobi, List<Integer> crong) {
		if ((pobi.get(0) == 1) || (crong.get(0) == 1)) {
			return true;
		}
		if ((pobi.get(1) == 400 || crong.get(1) == 400)) {
			return true;
		}
		return false;
	}

	/**
	 * 두 개의 인자 값이 연속적인 값인지를 확인하는 기능이다.
	 * 
	 * @param pobi
	 * @param crong
	 * @return 연속된 두 숫자가 아니면 true 맞으면 false
	 */
	public static boolean checkWrongPage(List<Integer> pobi, List<Integer> crong) {
		if ((Math.abs(pobi.get(1) - pobi.get(0)) > 1) 
			  || (Math.abs(crong.get(1) - crong.get(0)) > 1)) {
		return true;
		}

		return false;
	}

	/**
	 * pobi의 가장 큰 수를 찾는 기능이다.
	 * 
	 * @param pobi
	 * @return 더하기 또는 곱중 가장 큰 값을 리턴한다
	 */
	public static int maxPobiNumber(List<Integer> pobi) {
		int max = 0;
		max = Math.max(sum(pobi.get(0)), multiply(pobi.get(0)));
		max = Math.max(max, Math.max(sum(pobi.get(1)), multiply(pobi.get(1))));
		return max;
	}

	/**
	 * crong의 가장 큰 수를 찾는 기능이다.
	 * 
	 * @param crong
	 * @return 더하기 또는 곱중 가장 큰 값을 리턴한다
	 */
	public static int maxCrongNumber(List<Integer> crong) {
		int max = 0;
		max = Math.max(sum(crong.get(0)), multiply(crong.get(0)));
		max = Math.max(max, Math.max(sum(crong.get(1)), multiply(crong.get(1))));
		return max;
	}

	/**
	 * 게임의 결과를 확인하는 기능이다.
	 * 
	 * @param pobiMaxNumber
	 * @param crongMaxNumber
	 * @return 포비가 이기면 1 크롱이 이기면 2 무승부는 0을 리턴한다.
	 */
	public static int whoWin(int pobiMaxNumber, int crongMaxNumber) {
		if (pobiMaxNumber > crongMaxNumber)
			return 1;
		if (pobiMaxNumber < crongMaxNumber)
			return 2;
		return 0;
	}

	/**
	 * 각 자리 숫자를 모두 더하는 기능이다.
	 * 
	 * @param number
	 * @return 합의 결과를 리턴한다
	 */
	public static int sum(int number) {
		return number / 100 + (number % 100) / 10 + (number % 100) % 10;
	}

	/**
	 * 각 자리 숫자를 모두 곱하는 기능이다.
	 * 
	 * @param number
	 * @return 곱의 결과를 리턴한다
	 */
	public static int multiply(int number) {
		int times = 1;
		while (number > 0) {
			times *= (number % 10);
			number /= 10;
		}
		return times;
	}
}