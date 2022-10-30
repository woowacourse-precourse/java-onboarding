package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        
        int pobiMax = 0;
        
        for(int i=0; i<2; i++) {
        	int pobiValue = pobi.get(i);
            int pobiSum = 0;
            int pobiMul = 1;
        	
        	while(pobiValue!=0) {
        		pobiSum += pobiValue % 10;
        		pobiMul *= pobiValue % 10; 
        		pobiValue = pobiValue / 10;
        	}
        	pobiMax = Math.max(pobiMax, Math.max(pobiSum, pobiMul));
        }
        
        return answer;
    }
}