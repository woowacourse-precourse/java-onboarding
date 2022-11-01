package onboarding;

import java.util.List;

class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int answer = Integer.MAX_VALUE;
		if (Math.abs(pobi.get(0) - pobi.get(1)) > 1 || Math.abs(crong.get(0) - crong.get(1)) > 1)
			answer = -1;
		else {
			int po = cal(pobi);
			int cro = cal(crong);
			if (po > cro)
				answer = 1;
			else if (po < cro)
				answer = 2;
			else
				answer = 0;
		}

		return answer;
	}
	
	public static int cal(List<Integer> list) {
	      int max = 0;
	      int result = 0;
	      for(int i = 0; i < 2; i++) {
	         int page = list.get(i);
	         int sum = 0;
	         int multi = 1;
	         while(page > 0) {
	              int r =  page% 10;
	              page /= 10;
	              sum += r;
	              multi *= r;
	           }
	         if (sum > multi) result = sum;
	         else result = multi;
	         
	         if(result > max) max = result;
	      }
	      return max;
	   }
}