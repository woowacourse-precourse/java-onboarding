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
    
    int selectNum(List<Integer> arr) {
    	return Math.max(Math.max(digSum(arr.get(0)),digMul(arr.get(0))),Math.max(digSum(arr.get(1)),digMul(arr.get(1))));
    }
    
}