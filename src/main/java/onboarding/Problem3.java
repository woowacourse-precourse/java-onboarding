package onboarding;

public class Problem3 {
	public static int solution(int number) {
    	if(number <= 1 || number >= 10000) return -1; //예외
        int answer=0;        
    	for(int i=1;i<=number;i++) {
    		int one=i%10; //일의 자리 숫자
    		int ten=(i/10)%10; //십의 자리 숫자
    		int hundred=(i/100)%10; //백의 자리 숫자
    		int thousand=(i/1000)%10; //천의 자리 숫자
    		if(one == 3 ||one == 6 || one == 9) answer++;
    		if(ten == 3 || ten == 6 || ten == 9) answer++;
    		if(hundred == 3 || hundred == 6 || hundred == 9) answer++;
    		if(thousand == 3 || thousand == 6 || thousand == 9) answer++;
    	}
        return answer;
    }
}
