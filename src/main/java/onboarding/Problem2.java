package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
    
    private static String removeOverlap(String s) {
    	char c = s.charAt(0);
    	int n = 1;
    	
    	for(int i = 1; i < s.length(); i++) {
    		if(c != s.charAt(i)) {
    			if(n > 1) {
    				s = s.replace(s.substring(i - n, i), "");
    				i -= n;
    				n = 1;
    			}
    			c = s.charAt(i);
    		} else {
    			n++;
    		}
    	}
    	
    	if(n > 1) {
    		s = s.replace(s.substring(s.length() - n, s.length()), "");
    	}
    	
    	return s;
    }
}