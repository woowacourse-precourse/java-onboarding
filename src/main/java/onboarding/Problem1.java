package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        
        return answer;
    }
    public static boolean isException(Integer leftPage, Integer rightPage) {
    	
    	if(isNullPage(leftPage, rightPage)) {
    		return true;
    	}
    	
    	return false;
    	
    }
    public static boolean isNullPage(Integer leftPage, Integer rightPage) {
    	return leftPage==null || rightPage==null;
    }
    public static boolean isLeftPageInRange(int leftPage) {
    	return 1<=leftPage && leftPage<=399;
    }
    
}