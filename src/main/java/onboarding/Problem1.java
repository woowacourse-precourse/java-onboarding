package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
    	if((pobi.get(1) - pobi.get(0) != 1) || (crong.get(1) - crong.get(0) != 1)) {
    		return -1;
    	}
    	int[] vs = {pobi.get(0), pobi.get(1), crong.get(0), crong.get(1)};
    	int[] cal = {0, 0, 0, 0};
		int[] answer = {0, 0};
		
		for(int i = 0; i < 4; i++) {
			int num = 0;
			int[] sum_mul = {0, 1};
			int page = vs[i];
			
			for(int j = 2; j > 0; j--) {
				num = (int)(page / Math.pow(10, j));
				page = (int)(page % Math.pow(10, j));
				if(num == 0) continue;
				sum_mul[0] += num;
				sum_mul[1] *= num;
			}
			sum_mul[0] += page;
			sum_mul[1] *= page;
			cal[i] = Integer.max(sum_mul[0], sum_mul[1]);
		}
		
		answer[0] = Integer.max(cal[0], cal[1]);
		answer[1] = Integer.max(cal[2], cal[3]);
		
		if (answer[0] > answer[1]) return 1;
		else if(answer[0] < answer[1]) return 2;
		else return 0;
    }
}