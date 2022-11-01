package onboarding;

import java.util.List;

class Problem1 {
	// 게임을 진행한 후 승자를 반환한다.
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		// 게임을 진행할 수 있는지 확인한다.
		if (!isValidGame(pobi, crong)) {
			return -1;
		}
		// 규칙대로 한 연산의 최대값을 구한다.
		int player1Max = getMaxPageValue(pobi);
		int player2Max = getMaxPageValue(crong);
		// 승자를 결정한다.
		return decideWinner(player1Max, player2Max);
	}

	// 기능 1: 플레이어 둘 다 게임을 진행할 수 있는지 확인한다.
	private static boolean isValidGame(List<Integer> player1, List<Integer> player2) {
		// 반환값이 false일 경우, 게임을 진행할 수 없다.
		return isValidPage(player1) && isValidPage(player2);
	}

	// 기능 2: 플레이어가 가진 페이지의 최대값을 반환한다.
	private static int getMaxPageValue(List<Integer> player) {
		// 왼쪽 페이지 연산의 최대값과 오른쪽 페이지 연산의 최대값을 얻는다.
		int leftMaxValue = getMaxValueOfPage(player.get(0));
		int rightMaxValue = getMaxValueOfPage(player.get(1));
		// 두 연산 값 중 최대값을 반환.
		return getMaxValue(leftMaxValue, rightMaxValue);
	}

	// 기능 3: 게임의 규칙대로, 플레이어의 값을 비교해 승자를 결정한다.
	private static int decideWinner(int player1Value, int player2Value) {
		if (player1Value > player2Value) {
			return 1;
		} else if (player1Value < player2Value) {
			return 2;
		}
		return 0;
	}

	// 기능 2-1: 한 페이지의 자릿수에 대한 덧셈과 곱셈 값의 최대값을 반환한다.
	private static int getMaxValueOfPage(int page) {
		// 페이지의 자리수를 파악한다.
		int numberLength = identifyDigits(page);
		// 자릿수를 가지고 덧셈연산과 곱셈연산을 진행한다.
		int additionValue = addByDigits(page, numberLength);
		int productValue = productByDigits(page, numberLength);
		// 두 연산 결과를 비교해 최대값을 반환한다.
		return getMaxValue(additionValue, productValue);
	}

	// 공통기능 :  두 수 중에 큰 값을 반환한다.
	private static int getMaxValue(int number1, int number2) {
		return Math.max(number1, number2);
	}

	// 기능 1-1: 플레이어의 페이지가 게임을 할 수 있는지 판단한다.
	private static boolean isValidPage(List<Integer> player) {
		if (player.get(1) - player.get(0) != 1) {
			// 펼친 페이지에서 양쪽 수의 차이는 1보다 크면 안된다.
			return false;
		} else if (player.get(0) < 1 || player.get(1) > 400) {
			//페이지 범위를 벗어나면 게임을 진행할 수 없다.
			return false;
		}
		return true;
	}

	// 기능 2-1-1: 페이지가 몇 자리 수인지 파악한다.
	private static int identifyDigits(int page) {
		return (int) (Math.log10(page) + 1);
	}

	// 기능 2-1-2: 페이지의 각 자릿수로 덧셈연산을 하고 결과를 반환한다.
	private static int addByDigits(int page, int numberLength) {
		int addition = 0;
		// 낮은 자리부터 높은 자리까지 수를 한 자리 수로 분리한다.
		for (int i = 0; i < numberLength; i++) {
			// 한 자리 수로 분리한다.
			int temp = page % 10;
			addition += temp;
			// 이미 분리한 수를 제외시키기 위한 처리
			page /= 10;
		}
		return addition;
	}

	// 기능 2-1-3: 페이지의 각 자릿수로 곱셈연산을 하고 결과를 반환한다.
	private static int productByDigits(int page, int numberLength) {
		int product = 1;
		// 낮은 자리부터 높은 자리까지 수를 한 자리 수로 분리한다.
		for (int i = 0; i < numberLength; i++) {
			// 한 자리 수로 분리한다.
			int temp = page % 10;
			product *= temp;
			// 이미 분리한 수를 제외시키기 위한 처리
			page /= 10;
		}
		return product;
	}
}
