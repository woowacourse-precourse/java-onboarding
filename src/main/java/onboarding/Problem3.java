package onboarding;

public class Problem3 {
    public static int solution(int number) {
		int answer = 0;
        
		for (int i=1; i<number+1; i++) {
			String strNum = String.valueOf(i);
			
			answer += strNum.length() - strNum.replace("3", "").length();
			answer += strNum.length() - strNum.replace("6", "").length();
			answer += strNum.length() - strNum.replace("9", "").length();
		
		}
		
		return answer; 
    }
}
