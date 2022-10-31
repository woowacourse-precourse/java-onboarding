package onboarding;

import java.util.*;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
 
        int answer = 0;
        
        // 예외 처리
    	if (exception(pobi) || exception(crong)) {
    		answer = -1;
    		return answer;
    	}
    	
    	
    	// max값 계산 
    	if (maxPages(pobi) > maxPages(crong)) {
    		answer = 1;
    	}else if (maxPages(pobi) < maxPages(crong)){
    		answer = 2;
    	}else {
    		answer = 0;
    	}
    	

    	return answer;

    
    }
   
    static boolean exception( List<Integer> pages) {
    	int left = pages.get(0);
    	int right = pages.get(1);
    	
    	if (left != right-1 || left % 2 != 1 || right % 2 != 0) {
    		return true;
    	}else {
    		return false;
    	}
    			
    }
    
    static int maxPages(List<Integer> pages) {
    	
    	List<Integer> pageSum = new ArrayList<>();
    	
    	for (int page : pages) {
    		int sum = 0;
    		int mul = 1;
    				
    		String[] strArray = String.valueOf(page).split("");
    		
    		for (int i=0; i < strArray.length; i++) {
    			int num = Integer.parseInt(strArray[i]);
    			sum += num;
    			mul *= num;
    		}	
    		pageSum.add(Math.max(sum, mul));
    	}	
    	return Collections.max(pageSum);

	
    }	
}
