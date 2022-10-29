package onboarding;

public class Problem3 {
    public static int solution(int number) {
    
    	int answer = 0;
        return answer;
    }

	public static int countAllThreeSixNine(int num) {	
		
		int singleDigitNum = 0;
		int cnt = 0;
		while(num!=0) {
			singleDigitNum = num % 10;
			if(singleDigitNum % 3 == 0) {
				cnt += 1;
			}
			num = num / 10;
		}
		return cnt;
	}
    
}
