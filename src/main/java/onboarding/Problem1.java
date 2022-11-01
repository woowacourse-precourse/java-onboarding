package onboarding;

import java.util.List;

class Problem1 {
	// 1개의 페이지에서 나오는 2가지 경우중 큰 값 구하기
	// 2개의 페이지에서 각각 나온 값 비교하여 큰 값 구하기
	// 한 사람이 가진 두개의 페이지가 연속적인가확인
	
	public static int all_poss(String num) { // 한 페이지 중 최대값
		String[] arr = num.split("");
		int curr, plus = 0, mult = 1;
		for(String s : arr) {
			curr = Integer.parseInt(s);
			plus += curr;
			mult *= curr;
		}
		if (plus >= mult) {
			return plus;
		}
		return mult;
	}
	public static int get_max(List<Integer> person) { // 두 페이지중 최대값
		int max = 0, curr;
		for(Integer page: person) {
			String str_page = page.toString();
			curr = all_poss(str_page);
			if (max < curr) {
				max = curr;
			}
			
		}
		return max;
		
	}
	public static boolean check(List<Integer> p) { //두 페이지가 연속적인가확인
		if (p.get(0) + 1 == p.get(1)) {
			return true;
		}
		return false;
	}
	
	public static int solution(List<Integer> pobi, List<Integer> crong) {
    	int answer, l_max, r_max;
    	if (check(pobi) && check(crong)) {
    		l_max = get_max(pobi);
    		r_max = get_max(crong);
    		if (l_max > r_max) {
    			answer = 1;
    		}else if (l_max < r_max) {
				answer = 2;
			}else {
				answer = 0;
			}
    	}
    	else {
    		answer = -1;
    	}
    	
    	
        
        return answer;
    }
}