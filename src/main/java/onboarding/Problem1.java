package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        
        if(pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) {
        	return -1;
        }
        
        int pobimax = Math.max(sum(pobi.get(0)), sum(pobi.get(1)));
        int crongmax = Math.max(sum(crong.get(0)), sum(crong.get(1)));
        
        return pobimax > crongmax ? 1 : pobimax == crongmax ? 0 : 2;
    }
    
    public static int sum(int n) {
    	int sum = 0, mul = 1;
    	while(n != 0) {
    		sum += n % 10;
    		mul *= n % 10;
  
    		n /= 10;
    	}
    	
    	return Math.max(sum, mul);
    }
}