package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        
        for(int i=1; i<number+1; i++) {
        	int checkNum = i;
        	
        	while(checkNum!=0) {
        		if(checkNum%10==3 || checkNum%10==6 || checkNum%10==9) {
        			answer++;
        		}
        		checkNum = checkNum/10;
        	}
        }
        return answer;
    }
}
