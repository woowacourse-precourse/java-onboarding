package onboarding;

public class Problem3 {
    public static int solution(int number) {
        return solve(number);
    }
    
    static int solve(int num) {
    	int res = 0;
    	for(int i = 0; i <= num; i++) {
    		int sum = i;
    		while(sum > 0) {
    			int key = sum%10;
    			if(key == 3||key == 6||key == 9) {
    				res+=1;
    			}
    			sum = sum/10;
    		}
    	}
    	return res;
    }
}
