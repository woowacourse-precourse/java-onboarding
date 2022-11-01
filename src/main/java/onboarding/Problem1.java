package onboarding;

import java.util.List;

class Problem1 {
	// 1���� ���������� ������ 2���� ����� ū �� ���ϱ�
	// 2���� ���������� ���� ���� �� ���Ͽ� ū �� ���ϱ�
	// �� ����� ���� �ΰ��� �������� �������ΰ�Ȯ��
	
	public static int all_poss(String num) { // �� ������ �� �ִ밪
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
	public static int get_max(List<Integer> person) { // �� �������� �ִ밪
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
	public static boolean check(List<Integer> p) { //�� �������� �������ΰ�Ȯ��
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