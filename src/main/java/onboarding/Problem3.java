package onboarding;

/**
 * Problem3 기능 목록
 * 1. answer 변수 선언 및 초기화 하기
 * 2. 1에서 주어진 숫자까지 배열로 바꾸기
 * 3. 배열에 3,6,9로 나눠지는 숫자가 있는지 확인하기
 * 4. 있다면 answer 변수에 더해주기
 * 5. 반복문이 끝난 후 answer 변수를 리턴하기
 */
public class Problem3 {
	public static int solution(int number) {
		int answer = 0;

		for (int i = 1; i <= number; i++) {
			// 숫자를 배열로 바꾼다.
			int[] numArray = Problem1.getDigitArray(i);
			answer += get369Number(numArray);
		}

		return answer;
	}

	private static int get369Number(int[] array) {
		int sum = 0;

		for (int j : array) {
			// 배열이 3,6,9로 나누어지는 지 확인한다.
			sum += is369(j) ? 1 : 0;
			// 나누어진다면 sum + 1 한다.
		}

		return sum;
	}

	private static boolean is369(int j) {
		return (j == 3) || (j == 6) || (j == 9);
	}

}
