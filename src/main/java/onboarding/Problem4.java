package onboarding;

public class Problem4 {
    public static String solution(String word) {
    	
    	String answer = "";
        return answer;
    }
    public static char convertCharReverse(char target) {
    	char convertedChar;
    	if(Character.isUpperCase(target)) {
    		convertedChar = (char)(90-target+65);
    	} else {
    		convertedChar = (char)(122-target+97);
    	}
    	return convertedChar;
    }
}
