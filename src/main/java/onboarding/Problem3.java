package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        
        answer = clapSum(number);
        
        return answer;
    }
    
    // 1부터 number까지 박수의 합을 구하는 메소드
    public static int clapSum(int number) {
    	int cSum = 0;
    	for(int i = 1; i <= number; i++) {
    		cSum += clap(i);
    	}
    	return cSum;
    }
    
    // 해당 번호에 3,6,9가 들어있는 갯수 출력
    public static int clap(int number) {
    	int clap = 0;
    	while(number>0) {
    		int lastdigit = number%10;
    		if(lastdigit == 3 || lastdigit == 6 ||lastdigit == 9) {
    			clap++;
    		}
    		number /= 10;
    	}
    	return clap;
    }
    
}
