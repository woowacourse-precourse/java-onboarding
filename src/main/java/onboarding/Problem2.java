package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        return solve(cryptogram);
    }
    public static String solve(String s) {
    	while(true) {
    		boolean flag = false;
    		char[] ch = s.toCharArray();
    		for(int i = 0; i < ch.length - 1; i++) {
    			if(ch[i] == ch[i + 1]) {
    				ch[i] = ' ';
    				ch[i + 1] = ' ';
    				flag = true;
    			}
    		}
    		
    		if(!flag) {
    			break;
    		}
    		
    		s = new String(ch).replaceAll(" ", "");
    	}
    	return s;
    }
}
