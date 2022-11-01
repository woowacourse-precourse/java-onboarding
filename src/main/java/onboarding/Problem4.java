package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();
        
        for(char c : word.toCharArray()) {
        	if(c >= 'A' && c <= 'Z') {
    			sb.append((char)('Z' - c + 'A'));
    		}
        	else if(c >= 'a' && c <= 'z'){
    			sb.append((char)('z' - c + 'a'));
    		}
        	else {
        		sb.append(c);
        	}
        }
        
        return sb.toString();
    }
}
