package onboarding;

public class Problem3 {
	//369게임에서 number가 주어졌을 때 손뼉을 친 박수의 횟수를 센다.
	public static int solution(int number) {
		int totalClapNumber = 0;
		for (int currentTurn = 1; currentTurn <= number; currentTurn++) {
			// 현재 게임에서 숫자가 몇 자리인지 확인하다.
			int digits = identifyDigits(currentTurn);
			// 현재쳐야할 박수의 횟수를 더해 총 횟수를 구한다.
			totalClapNumber += countClapNumber(currentTurn, digits);
		}
		return totalClapNumber;
	}

	// 기능 1. number와 number의 자리수에 따라 쳐야할 박수의 횟수를 계산한다.
	private static int countClapNumber(int number, int digits) {
		int numberOfClap = 0;
		for (int trial = 1; trial <= digits; trial++) {
			// 자리수를 낮춘다.
			// 단, 첫째 자리 계산할 때는 예외처리를 한다.
			if (trial != 1) {
				number /= 10;
			}

			// 자리수가 3,6,9중 하나인지 파악하고 맞다면 총 횟수에 1을 더한다.
			if (isClap(number)) {
				numberOfClap++;
			}
		}
		return numberOfClap;
	}

	// 기능2. 현재 게임의 수가 몇 자리인지 확인하다.
	private static int identifyDigits(int number) {
		return (int) (Math.log10(number) + 1);
	}

	// 기능3. 자릿수의 숫자가 3,6,9중 하나라면 true를 반환한다.
	private static boolean isClap(int number) {
		int digit = number % 10;
		if (digit == 3 || digit == 6 || digit == 9) {
			return true;
		}
		return false;
	}
}
