package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        Integer pobiLeftPage = pobi.get(0);
        Integer pobiRightPage = pobi.get(1);
        Integer crongLeftPage = crong.get(0);
        Integer crongRightPage = crong.get(1);
        
        if(isCorrectPage(pobiLeftPage, pobiRightPage) && isCorrectPage(crongLeftPage, crongRightPage)) {
        	int pobiScore = getScore(pobiLeftPage, pobiRightPage);
        	int crongScore = getScore(crongLeftPage, crongRightPage);
        	if(pobiScore < crongScore) {
        		answer = 2;
        	} else if(pobiScore > crongScore){
        		answer = 1;
        	} else {
        		answer = 0;
        	}
        } else {
        	answer = -1;
        }
        return answer;
    }
    private static int getScore(int leftPage, int rightPage) {
    	
    	int leftPageScore = Math.max(sumAllNum(leftPage), multiAllNum(leftPage));
    	int rightPageScore = Math.max(sumAllNum(rightPage), multiAllNum(rightPage));
    	
    	if(leftPageScore < rightPageScore) {
    		return rightPageScore;
    	}
    	return leftPageScore;
    }
    private static int sumAllNum(int page) {
    	String p = page + "";
    	int totalSum = 0;
    	for(int i=0; i<p.length(); i++) {
    		totalSum += p.charAt(i) - '0';
    	}
    	return totalSum;
    }
    private static int multiAllNum(int page) {
    	String p = page + "";
    	int totalMulti = 1;
    	for(int i=0; i<p.length(); i++) {
    		totalMulti *= p.charAt(i) - '0';
    	}
    	return totalMulti;
    }
    private static boolean isCorrectPage(Integer leftPage, Integer rightPage) {
    	
    	if(nullPointException(leftPage, rightPage)) {
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
    	if(!isRightPageOneMore(leftPage, rightPage)) {
    		return false;
    	}
    	if(isOpeningPage(leftPage, rightPage)) {
    		return false;
    	}
    	if(isClosingPage(leftPage, rightPage)) {
    		return false;
    	}
    	return true;
    	
    }
    private static boolean isRightPageEven(int rightPage) {
    	return (rightPage % 2) == 0;
    }
    private static boolean isLeftPageOdd(int leftPage) {
    	return (leftPage % 2) == 1;
    }
    private static boolean isRightPageOneMore(int leftPage, int rightPage) {
    	return (rightPage - leftPage)==1;
    }
    private static boolean nullPointException(Integer leftPage, Integer rightPage) {
    	return leftPage==null || rightPage==null;
    }
    private static boolean isLeftPageInRange(int leftPage) {
    	return 1<=leftPage && leftPage<=399;
    }
    private static boolean isRightPageInRange(int rightPage) {
    	return 2<=rightPage && rightPage<=400;
    }
    private static boolean isOpeningPage(int leftPage, int rightPage) {
    	return (leftPage==1 && rightPage==2);
    }
    private static boolean isClosingPage(int leftPage, int rightPage) {
    	return (leftPage==399 && rightPage==400);
    }
    
}