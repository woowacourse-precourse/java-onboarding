package onboarding;

public class Problem3 {
	public static int solution(int number) {
        int answer = 0;
        for(int i = 1; i <= number; i++) {
        	int num = i;
        	while(num > 0) {
        		int r = num % 10;
        		if(String.valueOf(r).contains("3") ||String.valueOf(r).contains("6")||String.valueOf(r).contains("9")) {
            		answer++;
            	}
        		num /= 10;
        	}
        	
        }
        return answer;
    }
}
