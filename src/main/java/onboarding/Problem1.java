package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
    	
    	int[] pobi_page = new int[2];
    	int[] crong_page = new int[2];
    	int num = pobi.get(0);
        pobi_page[0] = sum_multiple_max(num);
    	num = pobi.get(1);
        pobi_page[1] = sum_multiple_max(num);
    	num = crong.get(0);
        crong_page[0] = sum_multiple_max(num);
    	num = crong.get(1);
        crong_page[1] = sum_multiple_max(num);
        int pobi_score = Math.max(pobi_page[0],pobi_page[1]);
        int crong_score = Math.max(crong_page[0], crong_page[1]);
        
        int answer = Integer.MAX_VALUE;
        if(pobi.get(0) < 2 || pobi.get(1) > 399 || crong.get(0) < 2 || crong.get(1) > 399 
        		|| pobi.get(0) % 2 == 0 || pobi.get(0) + 1 != pobi.get(1) || 
        		crong.get(0) % 2 == 0 || crong.get(0) + 1 != crong.get(1) ) {
        	answer = -1;
        } else if(pobi_score > crong_score) {
        	answer = 1;
        } else if (pobi_score < crong_score) {
        	answer = 2;
        } else if (pobi_score == crong_score) {
        	answer = 0;
        }
        return answer;
    }

	private static int sum_multiple_max(int num) {
		int sum = 0;
        int multiple = 1;
        
        while(num > 0) {
        	sum += num % 10;
        	multiple *= num % 10;
        	num /= 10;
        }
        int[] numbers = new int[2];
        numbers[0] = sum;
        numbers[1] = multiple;
        
        int max_number = Math.max(numbers[0], numbers[1]);
        return max_number;
	}
}