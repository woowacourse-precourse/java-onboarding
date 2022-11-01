package onboarding;

import java.util.List;

class Problem1 {
	static int psum_max = 0;
	static int pmul_max = 0;
	static int csum_max = 0;
	static int cmul_max = 0;
	
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        
        if(pobi.size()==2&&crong.size()==2&&Math.abs(pobi.get(0)-pobi.get(1))==1&&Math.abs(crong.get(0)-crong.get(1))==1) {
        	psum_max = allsum(pobi);
            csum_max = allsum(crong);
            pmul_max = allmul(pobi);
            cmul_max = allmul(crong);
            
            if(Math.max(psum_max, pmul_max) > Math.max(csum_max, cmul_max)) answer = 1;
            else if(Math.max(psum_max, pmul_max) < Math.max(csum_max, cmul_max)) answer = 2;
            else if(Math.max(psum_max, pmul_max) == Math.max(csum_max, cmul_max)) answer = 0;
           
        }else {
        	answer = -1;
        }
       
        return answer;
    }
    public static int allsum(List<Integer> list) {
    	int left = list.get(0);
    	int right = list.get(1);
    	int left_sum=0;
    	int right_sum=0;
    	
    	while(left!=0) {
    		left_sum+=left%10;
    		left=left/10;
    	}
    	
    	while(right!=0) {
    		right_sum+=right%10;
    		right=right/10;
    	}
    	return Math.max(left_sum, right_sum);
    }
    public static int allmul(List<Integer> list) {
    	int left = list.get(0);
    	int right = list.get(1);
    	int left_mul = 1;
    	int right_mul = 1;
    	
    	while(left!=0) {
    		left_mul *= (left % 10);
    		left = left/10;
    	}
     	while(right!=0) {
     		right_mul *= (right % 10);
    		right = right/10;
    	}
     	return Math.max(left_mul, right_mul);
    }
}