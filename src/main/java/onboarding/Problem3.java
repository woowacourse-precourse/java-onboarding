package onboarding;

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

	static int get369Number(int[] array) {
		int sum = 0;

		for (int j : array) {
			// 배열이 3,6,9로 나누어지는 지 확인한다.
			sum += is369(j) ? 1 : 0;
			// 나누어진다면 sum + 1 한다.
		}

		return sum;
	}

	static boolean is369(int j) {
		return (j == 3) || (j == 6) || (j == 9);
	}

}
