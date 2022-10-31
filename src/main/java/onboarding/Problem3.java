package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;        
		int cnt = 0;		
		for(int i=1; i<=number; i++) {
			int target = i;
			while(target!=0) {
				if(target%10==3 || target%10==6 || target%10==9) {
					cnt++;
				}
				target /= 10;				
			}
		}
		answer=cnt;        
        return answer;
    }
}