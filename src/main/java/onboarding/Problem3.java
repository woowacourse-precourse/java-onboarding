package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int j=0;
        
        for(int i=1; i<number; i++) {
        	j=i;
        	while(j>0) {
        		if(j%10==3 || j%10==6 || j%10==9) answer++;
        		j=j/10;
        	}
        }
        return answer;
    }
}