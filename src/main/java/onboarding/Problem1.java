package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
    	System.out.println("Problem1 start...");
    	int answer = Integer.MAX_VALUE;
    	// 예외 설정
    	if(pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) {
    		answer = -1;
    	} else{
	    	// 변수 할당
	    	int pobiPageNum = 0;
	    	int crongPageNum = 0;
	    	int pobiTotal = 0;
	    	int crongTotal = 0;
	    	
	     	
	    	for(int i = 0 ; pobi.size() > i; i++) {
	    		pobiPageNum = pobi.get(i);
	    		crongPageNum = crong.get(i);
	    		if(pobiTotal<sum(pobiPageNum)) pobiTotal = sum(pobiPageNum);
	    		if(crongTotal<sum(crongPageNum)) crongTotal = sum(crongPageNum);
	    		if(pobiTotal<multiplication(pobiPageNum)) pobiTotal = multiplication(pobiPageNum);
	    		if(crongTotal<multiplication(crongPageNum)) crongTotal = multiplication(crongPageNum);
	    	}
	    	
	    	if(pobiTotal > crongTotal) {
	    		answer = 1;
	    	} else if(pobiTotal < crongTotal) {
	    		answer = 2;
	    	} else if(pobiTotal == crongTotal) {
	    		answer = 0;
	    	}
    	}
		return answer;
    }
    
    // 합계 
    public static int sum(int pageNum) {
    	int sum = 0;
    	while(pageNum > 0) {
			sum += pageNum % 10;
			pageNum/=10;
		}
		return sum;
    }
    
    // 곱셈
    public static int multiplication (int pageNum) {
    	int multi = 1;
    	while(pageNum > 0) {
    		multi *= pageNum % 10;
    		pageNum/=10;
    	}
    	return multi;
    }
    
}