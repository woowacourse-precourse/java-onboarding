package onboarding;

import java.util.List;

class Problem1 {
	
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		
		boolean parameterConfirm = parameterCheck(pobi) && parameterCheck(crong);
		if(!parameterConfirm){
			return -1;
		}
		
		int pobiMaxValue = Integer.MIN_VALUE;
		for (Integer number : pobi) {
			int pobiIndexMaxValue = Math.max(sumValue(number), multipleValue(number));
			if (pobiIndexMaxValue > pobiMaxValue) {
				pobiMaxValue = pobiIndexMaxValue;
			}
		}
		
		int crongMaxValue = Integer.MIN_VALUE;
		for (Integer number : crong) {
			int pobiIndexMaxValue = Math.max(sumValue(number), multipleValue(number));
			if (pobiIndexMaxValue > crongMaxValue) {
				crongMaxValue = pobiIndexMaxValue;
			}
		}
		
		if(pobiMaxValue > crongMaxValue){
			return 1;
		}else if(pobiMaxValue < crongMaxValue){
			return 2;
		}else{
			return 0;
		}
		
	}
	
	private static boolean parameterCheck(List<Integer> user) {
		if(user.size() != 2){
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