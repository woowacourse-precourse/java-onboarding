package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Problem1 {
	
    public static int solution(List<Integer> pobi, List<Integer> crong) {
    	
    	int a = 0;
    	int b = 0;
    	int c = 0;
    	int sum = 0;
    	int gop = 0;
    	
    	List<Integer> pobiCal = new ArrayList<Integer>();
    	List<Integer> crongCal = new ArrayList<Integer>();
    	
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
    	
    	for(int num : pobi) {
    		
    		a = num / 100;
    		b = num / 10 - ( a * 10 );
    		c = num % 10;
    		sum = a + b + c;
    		
    		if(a == 0 && b == 0) {
    			gop = c;
    		} else if(a == 0) {
    			gop = b * c;
    		} else {
    			gop = a * b * c; 
    		}
    		
    		pobiCal.add(sum);
    		pobiCal.add(gop);
    	}
    	
    	for(int num : crong) {
    		
    		a = num / 100;
    		b = num / 10 - ( a * 10 );
    		c = num % 10;
    		sum = a + b + c;
    		
    		if(a == 0 && b == 0) {
    			gop = c;
    		} else if(a == 0) {
    			gop = b * c;
    		} else {
    			gop = a * b * c; 
    		}
    		
    		crongCal.add(sum);
    		crongCal.add(gop);
    	}
    	
    	Collections.sort(pobiCal, Collections.reverseOrder());
    	Collections.sort(crongCal, Collections.reverseOrder());
    	
    	int answer = Integer.MAX_VALUE;

    	if(pobiCal.get(0) > crongCal.get(0)) {
    		answer = 1;
    	} else if(pobiCal.get(0) < crongCal.get(0)) {
    		answer = 2;
    	} else if(pobiCal.get(0) == crongCal.get(0)) {
    		answer = 0;
    	} else if(pPage == 400 || pPage == 400 || cPage == 1 || cPage == 1) {
    		answer = -1;
    	} else {
    		answer = -1;
    	}
    		
        return answer;
    }
}