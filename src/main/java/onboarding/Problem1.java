package onboarding;

import java.util.List;

class Problem1 {
	 public static int solution(List<Integer> pobi, List<Integer> crong) {
	        int answer = Integer.MAX_VALUE;
		 	int pobi_score = cal_score(pobi);
	        int crong_score = cal_score(crong);
	        if(pobi_score ==-1 || crong_score ==-1) {return -1;}
	        if(pobi_score>crong_score) {
	        	answer = 1; // -1 이아니고 1을 return 하기
	        }else if(pobi_score==crong_score) {
	        	answer = 0;
	        }else {
	        	answer = 2;
	        }
	        return answer;
	    }
	    public static int cal_score(List<Integer> list) {
	    	int Lnum = list.get(0);
	    	int Rnum = list.get(1);
	    	if(Rnum-Lnum!=1) {return -1;} // 예외처리
	    	Lnum = find_max(Integer.toString(Lnum));
	    	Rnum = find_max(Integer.toString(Rnum));
	    	return Math.max(Lnum, Rnum);
	    }
	    public static int find_max(String tmp) {
	    	char[] nums = tmp.toCharArray();
	    	int sum = 0;
	    	int multiply = 1;
	    	for(char x : nums) {
	    		sum += Character.getNumericValue(x);
	    		multiply *= Character.getNumericValue(x);
	    	}
	    	
	    	return Math.max(sum,multiply);
	    }
}