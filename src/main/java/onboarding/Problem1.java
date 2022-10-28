package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        
        return answer;
    }
    public static boolean isCorrectPage(Integer leftPage, Integer rightPage) {
    	
    	if(isNullPage(leftPage, rightPage)) {
    		return false;
    	}
    	if(!isRightPageOneMore(leftPage, rightPage)) {
    		return false;
    	}
    	if(!isLeftPageInRange(leftPage)) {
    		return false;
    	}
    	if(!isRightPageInRange(rightPage)) {
    		return false;
    	}
    	if(!isLeftPageOdd(leftPage)) {
    		return false;
    	}
    	if(!isRightPageEven(rightPage)) {
    		return false;
    	}
    	return true;
    	
    }
    public static boolean isRightPageEven(int rightPage) {
    	return (rightPage % 2) == 0;
    }
    public static boolean isLeftPageOdd(int leftPage) {
    	return (leftPage % 2) == 1;
    }
    public static boolean isRightPageOneMore(int leftPage, int rightPage) {
    	return (rightPage - leftPage)==1;
    }
    public static boolean isNullPage(Integer leftPage, Integer rightPage) {
    	return leftPage==null || rightPage==null;
    }
    public static boolean isLeftPageInRange(int leftPage) {
    	return 1<=leftPage && leftPage<=399;
    }
    public static boolean isRightPageInRange(int rightPage) {
    	return 2<=rightPage && rightPage<=400;
    }
    
}