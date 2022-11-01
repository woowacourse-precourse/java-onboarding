package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiLeft = pobi.get(0);
		int pobiRight = pobi.get(1);
		int crongLeft = crong.get(0);
		int crongRight = crong.get(1);
		int pobiScore = 0;
		int crongScore = 0;
		int pobiScore1 = 1;
		int crongScore1 = 1;
		int pobiScore2 = 0;
		int crongScore2 = 0;
		int pobiScore3 = 1;
		int crongScore3 = 1;
		ArrayList<Integer> pobiLeftArr = new ArrayList<>();
		ArrayList<Integer> pobiRightArr = new ArrayList<>();
		ArrayList<Integer> crongLeftArr = new ArrayList<>();
		ArrayList<Integer> crongRightArr = new ArrayList<>();
		while(pobiLeft > 0) {
			pobiLeftArr.add(pobiLeft%10);
			pobiLeft /= 10;
		}
		for(int i : pobiLeftArr) {
			pobiScore += i;
			pobiScore1 *= i;
		}
		pobiScore = Math.max(pobiScore, pobiScore1);
		
		while(pobiRight > 0) {
			pobiRightArr.add(pobiRight%10);
			pobiRight /= 10;
		}
		for(int i : pobiRightArr) {
			pobiScore2 += i;
			pobiScore3 *= i;
		}
		pobiScore2 = Math.max(pobiScore2, pobiScore3);
		pobiScore = Math.max(pobiScore, pobiScore2);
		
		///
		while(crongLeft > 0) {
			crongLeftArr.add(crongLeft%10);
			crongLeft /= 10;
		}
		for(int i : crongLeftArr) {
			crongScore += i;
			crongScore1 *= i;
		}
		crongScore = Math.max(crongScore, crongScore1);
		
		while(crongRight > 0) {
			crongRightArr.add(crongRight%10);
			crongRight /= 10;
		}
		for(int i : crongRightArr) {
			crongScore2 += i;
			crongScore3 *= i;
		}
		crongScore2 = Math.max(crongScore2, crongScore3);
		crongScore = Math.max(crongScore, crongScore2);
		
		if(pobi.get(1)-pobi.get(0) != 1 || pobi.get(0) < 2 || pobi.get(1) > 400 || crong.get(1)-crong.get(0) != 1 || crong.get(0) < 2 || crong.get(1) > 400 || pobi.get(0)%2 != 1 || crong.get(0)%2 != 1) {
			answer = -1;
		}
		else if (pobiScore > crongScore) {
			answer = 1;
		}
		else if (pobiScore < crongScore) {
			answer = 2;
		}
		else {
			answer = 0;
		}
        
        return answer;
    }
}