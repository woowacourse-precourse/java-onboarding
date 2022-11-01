package onboarding;

/**
 * 
 * 기능 목롤 1) clap 2) checkGame 3) checkNumber
 * 
 * @version java 11 2022년 10월 30일
 * @author 이규호(tlqkrus012345)
 *
 */
public class Problem3 {

	static int answer = 0;

	public static int solution(int number) {
		clap(number);
		return answer;
	}

	/**
	 * 
	 * 숫자 1 ~ number까지 증가시키는 기능이다.
	 * 
	 * @param number
	 */
	public static void clap(int number) {
		for (int i = 1; i <= number; i++) {
			checkNumber(i);
		}
	}

	/**
	 * 
	 * 각 자리수를 확인하는 기능이다.
	 * 
	 * @param number
	 */
	public static void checkNumber(int number) {
		while (number > 0) {
			checkGame(number % 10);
			number /= 10;
		}
	}

	/**
	 * 
	 * 숫자에 3,6,9가 있는지 확인하는 기능이다
	 * 
	 * @param number
	 */
	public static void checkGame(int number) {
		if (number == 3 || number == 6 || number == 9) {
			answer++;
		}
	}
}
