package onboarding;

import java.util.List;

class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int answer = Integer.MAX_VALUE;      

		// 예외처리 코드
		if(checkException(pobi, crong) == -1) {
			return -1;
		}

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
}