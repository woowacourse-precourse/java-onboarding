package onboarding;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Problem1 {

	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int answer = Integer.MAX_VALUE;

		// 1. 책을 임의로 펼친다.
		int pRandom = (int) ((Math.random() * 400) + 1);
		int cRandom = (int) ((Math.random() * 400) + 1);

		if (pRandom % 2 == 1) {
			pobi.add(0, pRandom);
			pobi.add(1, pRandom + 1);
		} else if (pRandom % 2 == 0) {
			pobi.add(0, pRandom - 1);
			pobi.add(1, pRandom);
		}

		if (cRandom % 2 == 1) {
			crong.add(0, cRandom);
			crong.add(1, cRandom + 1);
		} else if (pRandom % 2 == 0) {
			crong.add(0, cRandom - 1);
			crong.add(1, cRandom);
		}
		
		// 2~3. 왼쪽/오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
    	List<Integer> pResults = new ArrayList<Integer>();
    	List<Integer> cResults = new ArrayList<Integer>();
    	
    	//// 포비 왼쪽 페이지 
    	int pNum1 = pobi.get(0)/100;
    	int pNum2 = (pobi.get(0) - pNum1*100) / 10;
    	int pNum3 = (pobi.get(0) - pNum1*100 - pNum2*10);
    	
    	pResults.add(pNum1 + pNum2 + pNum3);
    	if(pNum1 == 0) {    		
    		if(pNum2 == 0) {
    			pResults.add(pNum3);
    		} else {
    			pResults.add(pNum2 * pNum3);
    		}
    	} else {
        	pResults.add(pNum1 * pNum2 * pNum3);
    	}
    	
    	//// 포비 오른쪽 페이지 
    	pNum1 = pobi.get(1)/100;
    	pNum2 = (pobi.get(1) - pNum1*100) / 10;
    	pNum3 = (pobi.get(1) - pNum1*100 - pNum2*10);
    	
    	pResults.add(pNum1 + pNum2 + pNum3);
    	if(pNum1 == 0) {    		
    		if(pNum2 == 0) {
    			pResults.add(pNum3);
    		} else {
    			pResults.add(pNum2 * pNum3);
    		}
    	} else {
        	pResults.add(pNum1 * pNum2 * pNum3);
    	}
    	
    	//// 크롱 왼쪽 페이지 
    	int cNum1 = crong.get(0)/100;
    	int cNum2 = (crong.get(0) - cNum1*100) / 10;
    	int cNum3 = (crong.get(0) - cNum1*100 - cNum2*10);
    	
    	cResults.add(cNum1 + cNum2 + cNum3);
    	if(cNum1 == 0) {    		
    		if(cNum2 == 0) {
    			cResults.add(cNum3);
    		} else {
    			cResults.add(cNum2 * cNum3);
    		}
    	} else {
        	cResults.add(cNum1 * cNum2 * cNum3);
    	}
    	
    	//// 크롱 오른쪽 페이지 
    	cNum1 = crong.get(1)/100;
    	cNum2 = (crong.get(1) - cNum1*100) / 10;
    	cNum3 = (crong.get(1) - cNum1*100 - cNum2*10);
    	
    	cResults.add(cNum1 + cNum2 + cNum3);
    	if(cNum1 == 0) {    		
    		if(cNum2 == 0) {
    			cResults.add(cNum3);
    		} else {
    			cResults.add(cNum2 * cNum3);
    		}
    	} else {
        	cResults.add(cNum1 * cNum2 * cNum3);
    	}


		return answer;
	}
}