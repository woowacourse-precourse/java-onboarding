package onboarding;

public class Problem3 {

	/**
	 * 기능 목록 작성
	 * 1. 주어진 자연수까지 박수를 몇번 쳤는지 계산하는 기능
	 */
	public static int solution(int number) {
		int answer = 0;
		for (int i = 1; i <= number; i++) {
			answer += getClapCount(i);
		}
		return answer;
	}

	private static int getClapCount(int num) {
		int count = 0;
		while (num != 0) {
			if (num % 10 == 3 || num % 10 == 6 || num % 10 == 9) {
				count++;
			}
			num /= 10;
		}
		return count;
	}
}
