package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        
        for(int i = 1; i <= number; i++) {
        	String s = Integer.toString(i);
        	for(char c : s.toCharArray()) {
        		if((c - '0') % 3 == 0 && c != '0') {
        			answer++;
        		}
        	}
        }
        return answer;
    }
}
