package onboarding;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
 
    	if (isException(pobi) || isException(crong)) {
    		return -1;
    	}
    	if (maxPage(pobi) > maxPage(crong)) {
    		return 1;
    	} 
		if (maxPage(pobi) < maxPage(crong)){
    		return 2;
    	}
		if (maxPage(pobi) == maxPage(crong)) {
    		return 0;
    	}
		
		return -1;
    }
   
    static boolean isException( List<Integer> pages) {
    	int left = pages.get(0);
    	int right = pages.get(1);
    	
    	if (left != right-1 || left % 2 != 1 || right % 2 != 0) {
    		return true;
    	}
		return false;		
    }
     
    static int maxPage(List<Integer> pages) {
    	
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
