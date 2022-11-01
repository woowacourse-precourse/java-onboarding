package onboarding;

public class Problem3 {
	
    public static int solution(int number) {
    	
        int answer = 0;
        while(number>0) {
        	if(number%10 == 3 || number%10==6 || number%10==9) {
        		answer++;
        		number /=10;
        	}
        } 
        for(int b=0;a<answer;b++)
        	answer += b;
        return answer;
    }
    
    
	public static void main(String[] args) {
		
	
	int n = 10000;
	for(int a = 1; a<n;a++) {
		int cnt=solution(a);
		
		if(cnt==0) {
			
			} else {
				for(int l=0;l<cnt;l++)
			}
		}
	
	}
		
		

}
