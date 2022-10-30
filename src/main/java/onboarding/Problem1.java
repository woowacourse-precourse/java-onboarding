package onboarding;

import java.util.List;

class Problem1 {
	static boolean invalid(List<Integer> list) {
		/*List 길이가 2가 아니거나 페이지 다음장이 아닌 경우*/
		if(list.size() != 2 || list.get(0)+1 != list.get(1)) { 
			return true;
		}
		return false;
	}

	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int answer = Integer.MAX_VALUE;

		if(invalid(pobi) || invalid(crong)) { 
			answer = -1;
			return answer;
		}

		return answer;
	}
}