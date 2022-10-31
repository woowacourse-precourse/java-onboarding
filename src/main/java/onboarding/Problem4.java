package onboarding;

public class Problem4 {
    public static String solution(String word) {
    	StringBuilder wordSB = new StringBuilder(word);
    	
        for(int i = 0; i < wordSB.length(); i++) {
        	String convertedChar = String.valueOf(convertChar(wordSB.charAt(i)));
        	wordSB.replace(i, i+1, String.valueOf(convertedChar));
        }
        
        return wordSB.toString();
    }
    
    public static char convertChar(char c) {
    	char result = c;
    	if(65 <= c  && c <= 77) {
    		result = (char) (77+(78-c));
    	}else if(78 <= c  && c <= 90) {
    		result = (char) (78-(c-77));
    	}else if(97 <= c  && c <= 109) {
    		result = (char) (109+(110-c));
    	}else if(110 <= c  && c <= 122) {
    		result = (char) (110-(c-109));
    	}
    	return result;
    }
}