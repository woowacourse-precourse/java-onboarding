package onboarding;

public class Problem4 {
    public static String solution(String word) {
    	String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lower = upper.toLowerCase();
		String answer = "";
		
		for(int i = 1; i <= word.length(); i++) {
			char str = word.charAt(i-1);
			if (str == ' ') answer += str; 
			else if (Character.isUpperCase(str)) {
				int idx_upper = upper.indexOf(str);
				answer += upper.charAt(upper.length()-idx_upper-1);
			}
			else {
				int idx_lower = lower.indexOf(str);
				answer += lower.charAt(lower.length()-idx_lower-1);
			}
		}
		return answer;
    }
}
