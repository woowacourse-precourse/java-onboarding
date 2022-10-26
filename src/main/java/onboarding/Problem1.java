package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        answer = selectRes(pobi,crong);
        return answer;
    }
    
    static int digSum(int num){
    	int res = 0;
    	while (num > 0){
    		res += num % 10;
    		num = num / 10;
    	}
    	return res;
    }
    
    static int digMul(int num) {
    	int res = 1;
    	while (num > 0)
    	{
    		res *= num % 10;
    		num = num / 10;
    	}
    	return res;
    }
    
    static int selectNum(List<Integer> arr) {
    	return Math.max(Math.max(digSum(arr.get(0)),digMul(arr.get(0))),Math.max(digSum(arr.get(1)),digMul(arr.get(1))));
    }
    
    static boolean checkErr(List<Integer> arr) {
    	if (arr.get(0) > arr.get(1) || arr.get(0) < 0 || arr.get(1) > 400 || arr.get(1) - arr.get(0) != 1){
    		return false;
    	}else {
    		return true;
    	}
    }
    public static int selectRes(List<Integer> arr1, List<Integer> arr2) {
    	if (checkErr(arr1) && checkErr(arr2)){
    		int pobiN = selectNum(arr1);
        	int crongN = selectNum(arr2);
        	
        	if(pobiN == crongN) {
        		return 0;
        	}
        	else if(pobiN > crongN){
        		return 1;
        	}
        	else {
        		return 2;
        	}
    	}else {
    		return -1;
    	}
    }
}