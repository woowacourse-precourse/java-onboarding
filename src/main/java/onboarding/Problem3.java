package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        
        for(int i = 1; i <= number; i++) {
        	String num = Integer.toString(i);
        	answer += (num.length() - num.replace("3", "").length());
        	answer += (num.length() - num.replace("6", "").length());
        	answer += (num.length() - num.replace("9", "").length());
        }
        return answer;
    }
}
