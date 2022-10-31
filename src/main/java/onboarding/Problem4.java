package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for(int i = 0; i < word.length(); i++) {
        	if(Character.isLowerCase(word.charAt(i))) {
        		answer += (char)(('z' + 'a') - word.charAt(i));
        	}
        	else if(Character.isUpperCase(word.charAt(i))) {
        		answer += (char)(('Z' + 'A') - word.charAt(i));
        	}
        	else {
        		answer += word.charAt(i);
        	}
        }
        
        return answer;
    }
}
