package onboarding;

public class Problem3 {
    public static int solution(int number) {
    
    	int answer = startGame(number);
        return answer;
    }
    private static int startGame(int number) {
    	int totalClapNum = 0;
    	
    	for(int i=1; i<=number; i++) {
    		totalClapNum += countAllThreeSixNine(i);
    	}
    	return totalClapNum;
    }
	private static int countAllThreeSixNine(int num) {	
		int singleDigitNum = 0;
		int cnt = 0;
		
		while(num!=0) {
			singleDigitNum = num % 10;
			if(singleDigitNum!=0 && singleDigitNum % 3 == 0) {
				cnt += 1;
			}
			num = num / 10;
		}
		return cnt;
	}
    
}
