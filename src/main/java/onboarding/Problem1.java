package main.java.onboarding;

import java.util.Collections;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobi_score, crong_score;
        
        if(pobi.get(0) != pobi.get(1) - 1 || pobi.get(0) % 2 == 0 || pobi.get(0) < 1 || pobi.get(1) > 400) {
        	return -1;
        }
        if(crong.get(0) != crong.get(1) - 1 && crong.get(0) % 2 == 0 && crong.get(0) < 1 && crong.get(1) > 400) {
        	return -1;
        }
        
        pobi_score = maxval(pobi);
        crong_score = maxval(crong);
        
        if(pobi_score > crong_score) {
        	answer = 1;
        }
        else if(pobi_score < crong_score) {
        	answer = 2;
        }
        else {
        	answer = 0;
        }
        
        return answer;
    }
    
    public static int maxval(List<Integer> somelist) {
    	int x, y, result;
    	List<Integer> firstpage = List.of();
    	List<Integer> secondpage = List.of();
    	List<Integer> sumNmul = List.of();
    	
    	x = somelist.get(0);
    	y = somelist.get(1);
    	
    	while(x != 0) {
    		firstpage.add(x % 10);
    		x /= 10;
    	}
    	
    	while(y != 0) {
    		secondpage.add(x%10);
    		x /= 10;
    	}
    	
    	result = firstpage.stream().reduce((a, b) -> a + b).get();
    	sumNmul.add(result);
    	result = firstpage.stream().reduce((a,b) -> a * b).get();
    	sumNmul.add(result);
    	result = secondpage.stream().reduce((a, b) -> a + b).get();
    	sumNmul.add(result);
    	result = secondpage.stream().reduce((a, b) -> a * b).get();
    	sumNmul.add(result);
    	
    	return Collections.max(sumNmul);
    }
}