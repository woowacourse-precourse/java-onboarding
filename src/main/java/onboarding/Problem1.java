package onboarding;

import java.util.List;

class Problem1 {

	public static int solution(List<Integer> pobi, List<Integer> crong) {

		// ㅜ 초기 값 세팅을 위해 사용한 건가...
		int answer = Integer.MAX_VALUE;

		boolean isException = pobi.get(1) - crong.get(0) == 1 && crong.get(1) - crong.get(0) == 1;
		if (!isException) {

			answer = -1;
			return answer;
		}

		int pobiValue = getMaxValue(pobi.get(0), pobi.get(1));
		int crongValue = getMaxValue(crong.get(0), crong.get(1));

		if (pobiValue > crongValue) {

			answer = 1;
		}

		else if (crongValue > pobiValue) {

			answer = 2;
		}

		else if (crongValue == pobiValue) {

			answer = 0;
		}

		return answer;
	}

	public static int getMaxValue(int left, int right) {

		int sumLeftValue = sum(left);
		int multiplyLeftVaule = multiply(right);

		int leftValue = sumLeftValue >= multiplyLeftVaule ? sumLeftValue : multiplyLeftVaule;

		int sumRightValue = sum(right);
		int multiplyRightValue = multiply(right);

		int rightValue = sumRightValue >= multiplyRightValue ? sumRightValue : multiplyRightValue;

		return leftValue >= rightValue ? leftValue : rightValue;
	}

	/////////////////////////////////
	// ㅜ 각 자리 수를 더한 값을 반환하는 함수
	public static int sum(int pageNumber) {

		int result = 0;

		String _pageNumber = Integer.toString(pageNumber);

		for (int i = 0; i < _pageNumber.length(); i++) {

			result += Character.getNumericValue(_pageNumber.charAt(i));
		}

		return result;
	}

	/////////////////////////////////
	// ㅜ 각 자리 수를 곱한 값을 반환하는 함수
	public static int multiply(int pageNumber) {

		int result = 1;

		String _pageNumber = Integer.toString(pageNumber);

		for (int i = 0; i < _pageNumber.length(); i++) {

			result *= Character.getNumericValue(_pageNumber.charAt(i));
		}

		return result;
	}
}