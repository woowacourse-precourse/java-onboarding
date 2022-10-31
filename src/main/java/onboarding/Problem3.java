package onboarding;

public class Problem3 {
	public static int checkNum(int n) {
		int applause = 0;
		 while(n != 0) {
			int t = n % 10;
		 	if(t == 3 || t == 6 || t == 9) applause++;
		 	n /= 10;
		 }
		 return applause;
	}
	 
	
    public static int solution(int number) {
        int answer = 0;
        for(int i = 1; i <= number; i++) {
        	answer += checkNum(i);
        }
        return answer;
    }
}
