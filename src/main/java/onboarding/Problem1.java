package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
    
    int digSum(int num){
    	int res = 0;
    	while (num > 0){
    		res += num % 10;
    		num = num / 10;
    	}
    	return res;
    }
    
    int digMul(int num) {
    	int res = 1;
    	while (num > 0)
    	{
    		res *= num % 10;
    		num = num / 10;
    	}
    	return res;
    }
}