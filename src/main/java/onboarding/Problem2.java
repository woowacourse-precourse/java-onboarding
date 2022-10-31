package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        String tmp = "";
        int now = 0;
        
        while(now<answer.length()-1) {
        	if(answer.charAt(now)==answer.charAt(now+1)) {
        		tmp = ""+answer.charAt(now)+answer.charAt(now);
        		answer = answer.replace(tmp,"");
        		now--;
        	}
        	else
        		now++;
        }
        return answer;
    }
}
