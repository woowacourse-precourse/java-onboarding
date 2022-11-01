package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        
        if(pobi.get(1)-pobi.get(0)!=1 || crong.get(1)-crong.get(0)!=1) {
        	answer = -1;
        	return answer;
        }
        
        int pobiMax = 0;
        int crongMax = 0;
        
        for(int i=0; i<2; i++) {
        	int pobiValue = pobi.get(i);
            int pobiSum = 0;
            int pobiMul = 1;
            int crongValue = crong.get(i);
            int crongSum = 0;
            int crongMul = 1;
        	
        	while(pobiValue!=0) {
        		pobiSum += pobiValue % 10;
        		pobiMul *= pobiValue % 10; 
        		pobiValue = pobiValue / 10;
        	}
        	pobiMax = Math.max(pobiMax, Math.max(pobiSum, pobiMul));
        	
        	while(crongValue!=0) {
        		crongSum += crongValue % 10;
        		crongMul *= crongValue % 10;
        		crongValue = crongValue / 10;
        	}
        	crongMax = Math.max(crongMax,  Math.max(crongSum,  crongMul));
        }
        
        if(pobiMax>crongMax) answer = 1;
        else if(pobiMax<crongMax) answer = 2;
        else answer = 0;

        return answer;
    }
}