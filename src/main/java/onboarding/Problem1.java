package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
    	if(!isCorrect(pobi) || !isCorrect(crong)) {
    		return -1;
    	}
    	
        int answer = Integer.MAX_VALUE;
        int pobiScore = getBiggerScore(pobi);
        int crongScore = getBiggerScore(crong);
        
        answer = getScoreCompare(pobiScore, crongScore);
        
        return answer;
    }
    
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
	
	private static boolean isCorrect(List<Integer> list) {
		if(list.get(0) < 1 || list.get(1) > 400) {
			return false;
		}
		if(list.get(0) % 2 != 1 || list.get(1) % 2 != 0) {
			return false;
		}
		if(list.get(0) + 1 != list.get(1)) {
			return false;
		}
		return true;
	}
    
    private static int getBiggerScore(List<Integer> list) {
    	int score = 0;
    	
    	for(int i = 0; i < 2; i++) {
    		if(hasZero(list.get(i))) {
    			score = Math.max(score, Math.max(allAdd(list.get(1 - i)), allMul(list.get(1 - i))));
    		}
    	}
    	score = Math.max(score,  Math.max(allAdd(list.get(1)), allMul(list.get(1))));
    	
    	return score;
    }
    
    private static boolean hasZero(int n) {
    	return Integer.toString(n).contains("0");
    }
    
    private static int getScoreCompare(int n1, int n2) {
    	if(n1 - n2 > 0) {
    		return 1;
    	} else if(n1 - n2 < 0) {
    		return 2;
    	}
    	return 0;
    }
}