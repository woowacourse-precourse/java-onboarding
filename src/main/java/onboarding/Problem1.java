package onboarding;

import java.util.List;

class Problem1 {
	
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		
		// 입력 확인
		if (!parameterCheck(pobi) || !parameterCheck(crong)) {
			return -1;
		}
		
		// 유저별 큰 값 찾기
		int pobiMaxValue = pickMaxValue(pobi);
		int crongMaxValue = pickMaxValue(crong);
		
		// 비교
		if (pobiMaxValue > crongMaxValue) {
			return 1;
		} else if (pobiMaxValue < crongMaxValue) {
			return 2;
		} else {
			return 0;
		}
	}
	
	
	private static boolean parameterCheck(List<Integer> user) {
		if (user.size() != 2) {
			return false;
		}
		
		int left = user.get(0);
		int right = user.get(1);
		
		if (right - left != 1) {
			return false;
		} else if (right < 1 || right > 400) {
			return false;
		} else if (left < 1 || left > 400) {
			return false;
		} else if (right % 2 != 0) {
			return false;
		} else if (left % 2 != 1) {
			return false;
		}
		
		return true;
	}
	
	private static int pickMaxValue(List<Integer> user) {
		int maxValue = Integer.MIN_VALUE;
		for (Integer page : user) {
			int indexMaxValue = Math.max(sumValue(page), multipleValue(page));
			if (indexMaxValue > maxValue) {
				maxValue = indexMaxValue;
			}
		}
		return maxValue;
	}
	
	private static int sumValue(int num) {
		int result = 0;
		int numLength = checkLength(num);
		
		for (int i = 0; i < numLength; i++) {
			int tmpValue = num % 10;
			num /= 10;
			result += tmpValue;
		}
		
		return result;
	}
	
	private static int multipleValue(int num) {
		int result = 0;
		int numLength = checkLength(num);
		
		for (int i = 0; i < numLength; i++) {
			int tmpValue = num % 10;
			num /= 10;
			
			if (i == 0) {
				result = tmpValue;
			} else {
				result *= tmpValue;
			}
		}
		
		return result;
	}
	
	private static int checkLength(int num) {
		String s = Integer.toString(num).trim();
		return s.length();
	}
	
}