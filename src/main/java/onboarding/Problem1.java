package onboarding;

import java.util.List;

class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int answer = Integer.MAX_VALUE;      

		// 예외처리 코드
		if(checkException(pobi, crong) == -1) {
			return -1;
		}

		// 반환 값을 저장하는 코드(승자 확인)
		answer = compareValue(pageMaxValue(pobi), pageMaxValue(crong));

		return answer;
	}

	// 예외 처리 메소드
	public static int checkException(List<Integer> pobi, List<Integer> crong) {
		int result = 0;

		// 오른쪽 페이지가 짝수인지 확인
		if(pobi.get(1) % 2 != 0 || crong.get(1) % 2 != 0) {
			return -1;
		}

		// 오른쪽 페이지가 왼쪽 페이지보다 큰지, 차이가 1인지 확인
		if(pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) {
			return -1;
		}

		// 고른 페이지 중 1페이지, 혹은 400페이지가 있는지 확인
		if(pobi.get(0) == 1 || pobi.get(1) == 400) {
			return -1;
		}

		if(crong.get(0) == 1 || crong.get(1) == 400) {
			return -1;
		}

		return result;
	}

	// 최대 값을 구하는 메소드
	public static int pageMaxValue(List<Integer> page) {
		// 최대 값
		int maxValue = 0;
		// 모두 더한 값 중 최대 값
		int totalAddition = 0;
		// 모두 곱한 값 중 최대 값
		int totalMultiplication = 0;

		for(int i = 0; i < 2; i++) {
			// 더한 값
			int additionValue = 0;
			// 곱한 값
			int multiplicationValue = 0;

			additionValue = page.get(i) % 10;
			multiplicationValue = page.get(i) % 10;

			// 두 자리 이상인 경우
			if(9 < page.get(i)) {
				additionValue += page.get(i) % 100 / 10;
				multiplicationValue *= page.get(i) % 100 / 10;
			}

			// 세 자리 이상인 경우
			if(99 < page.get(i)) {
				additionValue += (page.get(i) / 100);
				multiplicationValue *= (page.get(i) / 100);
			}

			// 각 페이지 별 모두 더한 값 중 제일 큰 값
			if(totalAddition < additionValue) {
				totalAddition = additionValue;
			}

			// 각 페이지 별 모두 곱한 값 중 제일 큰 값
			if(totalMultiplication < multiplicationValue) {
				totalMultiplication = multiplicationValue;
			}
		}

		// 더한 값의 최대 값과 곱한 값의 최대 값 중 더 큰 값
		if(totalAddition >= totalMultiplication) {
			maxValue = totalAddition;
		}

		if(totalMultiplication >= totalAddition) {
			maxValue = totalMultiplication;
		}

		return maxValue;
	}

	// 승자를 구하는 메소드
	public static int compareValue(int pobi, int crong) {
		int result = 0;
		
		// 포비 승
		if (pobi > crong) {
			result = 1;
		}

		// 크롱 승
		if (crong > pobi) {
			result = 2;
		}

		// 무승부
		if (pobi == crong) {
			result = 0;
		}

		return result;
	}
}