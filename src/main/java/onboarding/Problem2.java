package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        String tmp = "";
        int now = 0;
        int cnt = 0;
        
        while(now<answer.length()-1) {
        	cnt = count(answer,now);
        	if(cnt>0) {
        		for(int i=0;i<=cnt;i++)
        			tmp += answer.charAt(now);
     
        		answer = answer.replace(tmp,"");
        		tmp = "";
        		now--;
        	}
        	else
        		now++;
        }
        return answer;
    }
    public static int count(String s,int now) {
    	int i = now;
    	int cnt =0;
    	while(i<s.length()-1) {
    		if(s.charAt(i)==s.charAt(i+1))
    			cnt++;
    		else 
    			break;
    		i++;
    	}
    	return cnt;
    }
}
