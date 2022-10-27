package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
    
    private static boolean isLowerCase(char ch) {
    	return (ch >= 97 && ch <= 122) ? true : false;
    }

    private static char getSymmetricAlphabet(char src) {
    	int startValue = 65;
    	int endValue = 90;
    	// 주어진 문자가 소문자라면 기준 값을 변경한다.
    	if (isLowerCase(src)) {
    		startValue = 97;
    		endValue = 122;
    	}
    	return (char) (endValue - (src - startValue));
    }
}
