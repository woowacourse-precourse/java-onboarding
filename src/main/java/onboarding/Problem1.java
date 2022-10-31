package onboarding;

import java.util.List;

class Problem1 {
	private static boolean invalid(List<Integer> list) {
		/*List 길이가 2가 아니거나 페이지 다음장이 아닌 경우*/
		if(list.size() != 2 || list.get(0)+1 != list.get(1)) { 
			return true;
		}
		return false;
	}

	private static int calc(List<Integer> list) {

		for(int page : list) { //비교 반복문
			int plus = 0;
			int sum = 1;

			while(page>0) {
				int pageOne = page % 10;

				plus += pageOne;
				sum *= pageOne;

				page = page/10;
			}
			if(plus >= sum) {
				return plus;
			} 
			return sum;
		}
		return 0;
	}

	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int answer = Integer.MAX_VALUE;

		if(invalid(pobi) || invalid(crong)) { 
			answer = -1;
			return answer;
		}
		int pobiResult = calc(pobi);
		int crongResult = calc(crong);

		if(pobiResult > crongResult) { //pobi가 이김
			answer = 1;
			return answer;
		}
		if(crongResult > pobiResult) { //crong이 이김
			answer = 2;
			return answer;
		} 

		answer = 0;
		return answer;
	}
}