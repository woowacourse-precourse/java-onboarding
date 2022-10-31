package onboarding;

import java.util.List;

class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int answer = Integer.MAX_VALUE;
		int pobi_left = pobi.get(0);
		int pobi_right = pobi.get(1);
		int crong_left = crong.get(0);
		int crong_right = crong.get(1);
		int pobi_max = Integer.MIN_VALUE;
		int crong_max = Integer.MIN_VALUE;

		// 예외사항 검증
		if(!check_sanity(pobi_left, pobi_right) ||
			!check_sanity(crong_left, crong_right))
			return -1;

		pobi_max = max_num(pobi_left, pobi_right);
		crong_max = max_num(crong_left, crong_right);

		if(pobi_max == crong_max)
			answer = 0;
		else if(pobi_max > crong_max)
			answer = 1;
		else
			answer = 2;

		return answer;
	}

	private static boolean check_sanity(int left, int right) {
		// 1 ~ 400 사이 검증
		if(left < 1 || right > 400)
			return false;
		// 페이지가 연속적이지 않다면 예외사항
		return left + 1 == right ? true : false;
	}

	private static int max_num(int left, int right) {
		// 오른쪽 페이지가 10의 배수라면 왼쪽 페이지가 가장 큰 수
		if(right % 10 == 0)
			return max_num(left);
		return max_num(right);
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
