package onboarding;

public class Problem3 {

	public static int solution(int number) {
		int answer = 0;

		answer = countClap(number);

		return answer;
	}

	/**
	 * 기능 1 박수 수 카운트 기능
	 */
	public static int countClap(int number) {
		int count = 0;

		for (int i = 1; i <= number; i++) {
			int temp = i;
			while (temp != 0) {
				if (temp % 10 == 3 || temp % 10 == 6 || temp % 10 == 9) // temp의 첫째 자리 수가 3,6,9일 경우
				{
					count++;
				}
				temp /= 10;
			}
		}
		return count;
	}
}
