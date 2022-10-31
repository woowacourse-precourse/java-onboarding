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
        
        return answer;
    }
}