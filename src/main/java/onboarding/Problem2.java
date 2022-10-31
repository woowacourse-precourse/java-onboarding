package onboarding;

public class Problem2 {
	public static boolean duplicated(String cryptogram) {
		for(int i = 0; i < cryptogram.length()-1; i++) {
        	if(cryptogram.charAt(i) == cryptogram.charAt(i+1)) {
        		return true;
        	}
        }
		return false;
	}
	
	public static String deleteDuplication(String cryptogram) {
		StringBuffer result = new StringBuffer();
		result.append(cryptogram);
		for(int i = 0; i < result.length() - 1; i++) {
        	if(result.charAt(i) == result.charAt(i+1)) {
        		result.deleteCharAt(i);
        		result.deleteCharAt(i);
        		i--;
        	}
        }
		return result.toString();
	}
	
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = cryptogram;
        while(duplicated(answer)) {
        	answer = deleteDuplication(answer);
        }
                
        return answer;
    }
}
