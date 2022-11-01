package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        
        for(int i = 1; i <= number; i++) {
        	String numStr = Integer.toString(i);
        	answer += getClapCnt(numStr);
        }
        
        return answer;
    }
    
    private static int getClapCnt(String s) {
    	int res = 0;
    	
    	for(int i = 0; i < s.length(); i++) {
    		if(s.charAt(i) == '3') {
    			res++;
    		} else if(s.charAt(i) == '6') {
    			res++;
    		} else if(s.charAt(i) == '9') {
    			res++;
    		}
    	}
    	
    	return res;
    }
}