package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        
        return answer;
    }
    public static boolean isException(List<Integer> pobi, List<Integer> crong) {
    	
    	if(isNullPage(pobi, crong)) {
    		return true;
    	}
    	
    	return false;
    	
    }
    public static boolean isNullPage(List<Integer> pobi, List<Integer> crong) {
    	
    	if((pobi.get(0)==null) || (pobi.get(1)==null) || (crong.get(0)==null) || (crong.get(1)==null)) {
    		return true;
    	}
    	return false;
    }
    public static boolean isLeftPageInRange(List<Integer> pobi, List<Integer> crong) {
    	
    	int pobiLeftPage = pobi.get(0);
    	int crongLeftPage = crong.get(0);
    	
    	if(1<=pobiLeftPage && pobiLeftPage<=399 && 1<=crongLeftPage && crongLeftPage<=399) {
    		return true;
    	}
    	return false;
    }
}