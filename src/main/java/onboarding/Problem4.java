package onboarding;

public class Problem4 {
    public static String solution(String word) {
    	char upper_sum = 'A'+'Z';
    	char lower_sum = 'a'+'z';
    	StringBuilder sb = new StringBuilder();
    	
        for(int i=0;i<word.length();i++) {
        	char c = word.charAt(i);
        	if(c>='a'&&c<='z') {
        		sb.append((char)(lower_sum-c));
        	}else if(c>='A'&&c<='Z') {
        		sb.append((char)(upper_sum-c));
        	}else {
        		sb.append(c);
        	}
        }
        return sb.toString();
    }
}
