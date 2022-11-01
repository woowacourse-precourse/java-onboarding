package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        
        answer = changeStr(word);
        
        return answer;
    }
    
    private static int getAlphabetIdx(char c) {
    	int res = 0;
    	
    	if(Character.isUpperCase(c)) {
    		res = c - 'A';
    	} else {
    		res = c - 'a';
    	}
    	
    	return res;
    }
    
    private static String changeStr(String s) {
    	String res = "";
    	
    	for(int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	
        	if(c == ' ') {
        		res += c;
        	} else if(Character.isUpperCase(c)) {
        		res += (char)('Z' - getAlphabetIdx(c));
        	} else if(Character.isLowerCase(c)){
        		res += (char)('z' - getAlphabetIdx(c));
        	} else {
        		res += c;
        	}
        }
    	
    	return res;
    }
}