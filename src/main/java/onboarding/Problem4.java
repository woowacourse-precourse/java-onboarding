package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();
        for(char c : word.toCharArray()) {
        	if(c == ' ') {
        		sb.append(" ");
        	}
        	else {
        		if(c >= 'A' && c <= 'Z') {
        			sb.append((char)('Z' - c + 'A'));
        		}
        		else {
        			sb.append((char)('z' - c + 'a'));
        		}
        	}
        }
        return sb.toString();
    }
}
