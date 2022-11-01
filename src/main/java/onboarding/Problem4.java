package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char c;
        for(int i=0;i<word.length();i++) {
        	c = word.charAt(i);
        	
        	if('A'<= c && c <='Z')
        		answer+= (char)(155-c);
        	else if('a'<= c && c <='z')
        		answer+= (char)(219-c);
        	else if(c==' ')
        		answer+=" ";
        }
        return answer;
    }
}
