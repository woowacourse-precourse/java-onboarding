package onboarding.pageGame;

import java.util.List;

// 두 명의 플레이어를 받아 페이지 게임을 수행하는 클래스
public class PageGame {
	List<Integer> player1;
	List<Integer> player2;

	public PageGame(List<Integer> player1, List<Integer> player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	// 기능1. 게임의 승자를 결정한다.
	public int findWinner() {
		// 페이지 조건이 맞지 않으면 -1을 출력
		if (!(isException(player1) && isException(player2))) {
			return -1;
		}
		// 각 플레이어의 페이지 최대값을 구함
		int player1Max = compareLeftAndRight(player1);
		int player2Max = compareLeftAndRight(player2);
		// 최대값을 비교해서 승자를 출력
		if (player1Max > player2Max) {
			return 1;
		} else if (player1Max < player2Max) {
			return 2;
		}
		// 비기는 경우
		return 0;
	}

	// 기능2. 왼쪽 페이지와 오른쪽 페이지 중 최대값을 반환
	public int compareLeftAndRight(List<Integer> player) {
		int leftMaxValue = calculateMaxValue(player.get(0));
		int rightMaxValue = calculateMaxValue(player.get(1));

		int determination = Integer.compare(leftMaxValue, rightMaxValue);
		// determination이 0보다 크면 left가 더 큰 값, 0보다 작거나 같으면 right가 더 크거나 같다.
		return determination > 0 ? leftMaxValue : rightMaxValue;
	}

	// 기능3. 페이지의 각 자리 숫자를 모두 더하거나 곱한 결과 중 최대값을 찾는다.
	public int calculateMaxValue(int page) {
		// 페이지의 자릿수를 판단
		int numberLength = (int) (Math.log10(page) + 1);

		// 페이지를 한 자리씩 분리
		int addition = 0, product = 1;
		for (int i = 0; i < numberLength; i++) {
			int temp = page % 10;
			// 각 자리 수를 곱하고 더한다.
			addition += temp;
			product *= temp;
			page /= 10;
		}

		// 최대값을 찾는다
		int determination = Integer.compare(addition, product);
		if (determination > 0) {
			return addition;
		}
		return product;
	}

	// 기능4. 페이지의 예외사항 판단.
	public boolean isException(List<Integer> player) {
		// 오른쪽 페이지와 왼쪽 페이지의 차이가 1일 때 같은 페이지이다.
		return player.get(1) - player.get(0) == 1;
	}
}
