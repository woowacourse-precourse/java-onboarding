package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        answer = execute(pobi, crong);
        return answer;
    }
    
	/* 입력된 배열을 비교해서 결과를 리턴한다. */
    private static int execute(List<Integer> pobi,List<Integer> crong) {
    	int result = -1;
    	if( validation(pobi) && validation(crong)) {
    		int pobiMax = getMax(pobi);
    		int crongMax = getMax(crong);
    		
    		if (pobiMax > crongMax) {
    			result = 1;
    		} else if (pobiMax < crongMax) {
    			result = 2;
    		} else {
    			result = 0;
    		}
    	}
		return result;
	}
    
    
    /* 입력된 값을 계산해서 가장 큰 수를 구한다. */
    private static int getMax(List<Integer> num) {
		int max = 0; // pobi의 가장 큰 수 
		
		for (int i = 0; i < num.size(); i++) {
			if (max < getSum(num.get(i))) {
				max = getSum(num.get(i));
			}
			if (max < getMulti(num.get(i))) {
				max = getMulti(num.get(i));
			}
		}
		return max;
	}
    
    /* 입력된 각 자리 숫자의 합계를 구한다. */
    private static int getSum(int num) {
		int value = 0;
		
		String sNum = String.valueOf(num);
		for (int i = 0; i < sNum.length(); i++) {
		
			value += Integer.parseInt(String.valueOf(sNum.charAt(i)));
		}
		return value;
	}
    
	/* 입력된 각 자리 숫자의 곱셈을 구한다. */
	private static int getMulti(int num) {
		int value = 1;
		
		String sNum = String.valueOf(num);
		for (int i = 0; i < sNum.length(); i++) {
			value *= Integer.parseInt(String.valueOf(sNum.charAt(i)));
		}
		return value;	
	}
	
	private static boolean validation(List<Integer> list) {
		boolean isSuccess = false;
		if( list.size() == 2) {
			if( list.get(1) == list.get(0) + 1) {
				isSuccess = true;
			}
		}
		return isSuccess;	
	}
}