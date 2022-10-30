package onboarding;

import java.util.List;

class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int answer = Integer.MAX_VALUE;
		int pobi_left = pobi.get(0);
		int pobi_right = pobi.get(1);
		int crong_left = crong.get(0);
		int crong_right = crong.get(1);

		// 예외사항 검증
		if(!check_sanity(pobi_left, pobi_right) ||
			!check_sanity(crong_left, crong_right))
			return -1;

		return answer;
	}

	private static boolean check_sanity(int left, int right) {
		// 페이지가 연속적이지 않다면 예외사항
		return left + 1 == right ? true : false;
	}

	private static int max_num(int num) {
		int multiply = Problem1.multiply(num);
		int sum = Problem1.sum(num);

		if(multiply > sum)
			return multiply;
		return sum;
	}

	private static int multiply(int num) {
		int ret = 1;

		while(num > 0) {
			ret *= num % 10;
			num /= 10;
		}

		return ret;
	}

	private static int sum(int num) {
		int ret = 0;

		while(num > 0) {
			ret += num % 10;
			num /= 10;
		}

		return ret;
	}
}
