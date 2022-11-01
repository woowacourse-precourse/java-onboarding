package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
    	int answer = Integer.MAX_VALUE;
    	// 예외사항 있는지 확인
    	if (isNotValid(pobi) || isNotValid(crong)) {
        	answer = -1;
        }
    	// 포비와 크롱의 수 비교
    	else {
    		int pobiScore = Math.max(calPage(pobi.get(0)), calPage(pobi.get(1)));
    		int crongScore = Math.max(calPage(crong.get(0)), calPage(crong.get(1)));
    		if (pobiScore > crongScore) {
    			answer = 1;
    		}
    		else if (crongScore > pobiScore) {
    			answer = 2;
    		}
    		else answer = 0;
    	}
        return answer;
    }
    
    // 예외처리 함수
    private static boolean isNotValid(List<Integer> page) {
    	if (page.get(0) == null || page.get(1) == null || page.size() != 2) {
            return true;
    	}
    	int leftPage = page.get(0);
    	int rightPage = page.get(1);
    	
    	if (rightPage - leftPage != 1 || rightPage >= 400 || leftPage <= 1) {
    		return true;
    	}
    	
    	if (leftPage % 2 == 0 || rightPage % 2 == 1) {
    		return true;
    	}
    	
    	return false;
    }
    
    // 최대값 계산 함수
    public static int calPage(int page) {
        int sumNum = 0;
        int mulNum = 1;
        while (page != 0) {
            sumNum += page % 10;
            mulNum *= page % 10;
            page /= 10;
        }
        return Math.max(sumNum, mulNum);
    
    }
    
    
}