package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder sb = new StringBuilder(cryptogram);
        
        for(int i=1;i<sb.length();) {
        	char left_char = sb.charAt(i-1);
        	char right_char = sb.charAt(i);
        	
        	if(left_char == right_char) {
        		sb.delete(i-1, i+1);
        		if(i!=1) {
        			i--;
        		}
        	}else {
        		i++;
        	}
        }
        
        return sb.toString();
    }
}
