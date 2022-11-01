package onboarding;

import java.util.List;
import static java.lang.Math.max;

class Problem1 {
	
	//왼쪽 페이지
	private static int getLeft(List<Integer> list) {
		int sum = 0;
		int product = 1;
		
		Integer num=list.get(0);
		while(num!=0) {
			sum += list.get(0)%10;
			product *= list.get(0)%10;
			num /= 10;
		}
		return max(sum, product);
	}
	
	//오른쪽 페이지
	private static int getRight(List<Integer> list) {
		int sum = 0;
		int product = 1;
		
		Integer num=list.get(1);
		while(num!=0) {
			sum += list.get(1)%10;
			product *= list.get(1)%10;
			num /= 10;
		}
		return max(sum, product);
	}
	
	
	//승자 구하기
	private static int compare(int a, int b) {
    	if (a>b) {
    		return 1;
    	}
    	else if (a<b) {
    		return 2;
    	}
    	else if (a==b){
    		return 0;
    	}
    	else {
    		return -1;
    	}
	}
	
    public static int solution(List<Integer> pobi, List<Integer> crong) {
    	
    	//pobi의 점수
    	int  p_score = (getLeft(pobi) > getRight(pobi)) ? getLeft(pobi): getRight(pobi);
    	//crong의 점수
    	int  c_score = (getLeft(crong) > getRight(crong)) ? getLeft(crong): getRight(crong);
        
        int answer = Integer.MAX_VALUE;
        answer = compare(p_score, c_score);
        
        return answer;
    }

}
