package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Problem1 {
	
    public static int solution(List<Integer> pobi, List<Integer> crong) {
    	
    	int pPage = (int)((400)*Math.random( ) + 1);
    	int cPage = (int)((400)*Math.random( ) + 1);
    	
    	if(pPage % 2 == 0) {
    		pobi.add(pPage-1);
    		pobi.add(pPage);
    	} else {
    		pobi.add(pPage);
    		pobi.add(pPage+1);
    	}
    	
    	if(cPage % 2 == 0) {
    		crong.add(cPage-1);
    		crong.add(cPage);
    	} else {
    		crong.add(cPage);
    		crong.add(cPage+1);
    	}
    	
        int answer = Integer.MAX_VALUE;
    		
        return answer;
    }
}