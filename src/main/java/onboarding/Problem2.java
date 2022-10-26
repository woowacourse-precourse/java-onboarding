package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        return solve(cryptogram);
    }
    public static String solve(String s) {
    	while(true) {
    		if(s.equals("")) {
    			break;
    		}
    		
    		boolean flag = false;
    		char[] ch = s.toCharArray();
    		for(int i = 0; i < ch.length - 1; i++) {
    			if(ch[i] == ch[i + 1]) {
    				ch[i] = Character.MIN_VALUE;
    				ch[i + 1] = Character.MIN_VALUE;
    				flag = true;
    			}
    		}
    		
    		s = "";
    		for(int i = 0; i < ch.length; i++) {
    			if(ch[i] != Character.MIN_VALUE) {
    				s += ch[i];
    			}
    		}
    		
    		if(!flag) {
    			break;
    		}
    	}
    	return s;
    }
}
