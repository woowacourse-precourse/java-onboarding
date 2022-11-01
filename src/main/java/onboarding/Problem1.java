package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        
        if(check(pobi)||check(crong))
        	return -1;
        
        int a = max(pobi);
        int b = max(crong);
        
        if(a>b)
        	answer = 1;
        else if(a<b)
        	answer = 2;
        else
        	answer = 0;
        
        return answer;
    }
    public static int max(List<Integer> user) {
    	return Math.max(Math.max(cal(user.get(0),0),cal(user.get(0),1)),Math.max(cal(user.get(1),0),cal(user.get(1),1)));
    }
    
    public static boolean check(List<Integer> list) {
    	if(list.get(0)+1 == list.get(1) && list.get(0)%2 == 1 && 1<=list.get(0) && list.get(0)<400)
    		return false;
    	else
    		return true;
    }
    // b = 0 이면 더하고 1이면 곱함
    public static int cal(int a, int b) {
    	int answer = b==0?0:1;
    	int tmp = a;
    	
    	while(tmp != 0) {
    		if(b ==0)
    			answer += tmp%10;
    		else
    			answer *= tmp%10;
    		
    		tmp /= 10;
    	}
    	
    	return answer;
    }
}