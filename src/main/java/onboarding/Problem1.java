package onboarding;

import java.util.List;

class Problem1 {
	private static int allAdd(int n) {
		int res = 0;
		
		while(n != 0) {
			res += n % 10;
			n /= 10;
		}
		return res;
	}
	
	private static int allMul(int n) {
		int res = 1;
		
		while(n != 0) {
			res *= n % 10;
			n /= 10;
		}
		return res;
	}
	
	private static int selectBigger(int n1, int n2) {
		return Math.max(n1, n2);
	}
	
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiAddLeftPage = allAdd(pobi.get(0));
        int pobiAddRightPage = allAdd(pobi.get(1));
        int crongAddLeftPage = allAdd(crong.get(0));
        int crongAddRightPage = allAdd(crong.get(1));
        int pobiMulLeftPage = allMul(pobi.get(0));
        int pobiMulRightPage = allMul(pobi.get(1));
        int crongMulLeftPage = allMul(crong.get(0));
        int crongMulRightPage = allMul(crong.get(1));
        
        int pobiScore = selectBigger(Math.max(pobiAddLeftPage, pobiAddRightPage), Math.max(pobiMulLeftPage, pobiMulRightPage));
        int crongScore = selectBigger(Math.max(crongAddLeftPage, crongAddRightPage), Math.max(crongMulLeftPage, crongMulRightPage));
        
        if(pobiScore > crongScore) {
        	answer = 1;
        } else if(pobiScore < crongScore) {
        	answer = 2;
        } else {
        	answer = 0;
        }
        
        return answer;
    }
}