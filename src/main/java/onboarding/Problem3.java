package onboarding;

import java.util.Arrays;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        
        for(int i=1;i<=number;i++) {
        	int a = i;
        	while(a!=0) {
        		if(a%10==3||a%10==6||a%10==9) {
        			answer+=1;
        		}
        		a=a/10;
        	}
        }
        return answer;
    }
}
