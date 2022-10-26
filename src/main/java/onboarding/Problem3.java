package onboarding;

public class Problem3 {
    public static int solution(int number) {
        return solve(number);
    }
    
    static int solve(int num) {
    	int res = 0;
    	for(int i = 0; i <= num; i++) {
    		char[] ch = Integer.toString(i).toCharArray();
    	
    		for(int j = 0; j < ch.length; i++) {
    			if(ch[j]=='3'||ch[j]=='6'||ch[j]=='9') {
    				res+=1;
    			}
    		}
    	}
    	return res;
    }
}
