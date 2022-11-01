package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i=0; i<=number; i++) {
        	String num1 = String.valueOf(i);
        	String[] num2 = num1.split("");
        	for(String num3 : num2) {
        		if(Integer.parseInt(num3) % 3 == 0 && Integer.parseInt(num3) != 0) {
        			answer ++;
        		}
        	}
        }
        return answer;
    }
}

 