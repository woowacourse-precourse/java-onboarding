package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char uppercaseAlphabetArr[] = {'Z', 'Y', 'X', 'W', 'V', 'U', 'T', 'S', 'R', 'Q', 'P', 'O', 'N', 'M', 'L', 'K', 'J', 'I', 'H', 'G', 'F', 'E', 'D', 'C', 'B', 'A'};
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
}