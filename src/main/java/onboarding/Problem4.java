package onboarding;

public class Problem4 {
    public static String solution(String word) {
        return solve(word);
    }
    
    static String solve(String word) {
    	char[] ch = word.toCharArray();
    	
    	for(int i = 0; i < ch.length; i++) {
    		if(ch[i]==' ') {
    			continue;
    		}
 
    		if(ch[i] >= 97 && ch[i] <= 122) {
    			int chN = ch[i];
        		chN += (25-2*(chN-97));
        		ch[i] = (char)chN;
    		}else if(ch[i] >= 65 && ch[i] <= 90) {
    			int chN = ch[i];
        		chN += (25-2*(chN-65));
        		ch[i] = (char)chN;
    		}else {
    			continue;
    		}
    	}
    	
    	String res = "";
    	for(int i = 0; i < ch.length; i++) {
    		res += ch[i];
    	}
    	
    	return res;
    }
}
