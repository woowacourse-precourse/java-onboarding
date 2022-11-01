package onboarding;

import java.util.List;

class Problem1 {
	public static int Max(int num) {
		int sum1=0,sum2=1;
		while(num>2 && num<399) {
			sum1 += num%10;
			sum2 *= num%10;
			
			num = num/10;
		}
		if(sum1 >= sum2) {
			return sum1 ;
		} else {
			return sum2;
		}
	}
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiMax = 0;int crongMax=0;
        if(pobiMax>crongMax) {
        	answer = 1;
        } else if (crongMax>pobiMax) {
        	answer = 2;
        } else answer = 0;
        return answer;
        
    }
}