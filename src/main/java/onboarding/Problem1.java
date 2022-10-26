package onboarding;

import java.util.List;

class Problem1 {

    /**
     * 기능 목록 작성
     * 1. 양쪽 페이지중 가장 큰값을 구하는 기능 (조건 2, 3의 식으로 구한다.)
     * 2. 1기능으로 찾은 값을 비교해 승자에 맞는 값을 리턴하는 기능
     * 3. 예외상황 조건에 부합하면 -1리턴 하는 기능
     * 예외사항 조건정리
     * 1. 페이지가 [1, 2] 또는 [399, 400]
     * 2. 페이지가 붙어있지 않은경우 ex) [99, 102]
     * 3. 페이지 순서가 [홀, 짝]이 아닌경우
     */
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int pobiMaxNum = findMaxNum(pobi);
		int crongMaxNum = findMaxNum(crong);

		int answer = Integer.MAX_VALUE;
		return answer;
	}

	private static int findMaxNum(List<Integer> pageList) {
		int maxValue = Integer.MIN_VALUE;
		for (Integer page : pageList) {
			if (page < 10) {
				maxValue = Math.max(maxValue, page);
			} else if (page < 100) {
				int units = page % 10;
				int tens = page / 10;

				int bigNum = Math.max(units + tens, units * tens);
				maxValue = Math.max(maxValue, bigNum);
			} else {
				int units = page % 10;
				int tens = (page / 10) % 10;
				int hundreds = page / 100;

				int bigNum = Math.max(units + tens + hundreds, units * tens * hundreds);
				maxValue = Math.max(maxValue, bigNum);
			}
		}
		return maxValue;
	}
}
