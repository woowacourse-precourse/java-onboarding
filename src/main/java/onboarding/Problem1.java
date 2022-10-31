package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
    
    
    private static isNotValid(List<Integer> page) {
    	int leftPage = page.get(0);
    	int rightPage = page.get(1);
    	
    	if (rightPage - leftPage != 1 || rightPage > 400) {
    		return true;
    	}
    	
    	if (leftPage % 2 == 0 || rightPage % 2 == 1) {
    		return true;
    	}
    	
    	return false;
    }
    
    
}