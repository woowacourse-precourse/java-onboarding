package onboarding.problem1.application.bookgame;

import static onboarding.problem1.Problem1Constant.*;

public enum BookGameStatus {

	WINNER_POBI("Pobi가 이겼습니다.", POBI_WIN_CODE),
	WINNER_CRONG("Crong이 이겼습니다.", CRONG_WIN_CODE),
	DRAW("비겼습니다.", DRAW_CODE),
	ERROR("예외 사항이 발생하였습니다.", EXCEPTION_CODE);

	private final String message;
	private final int statusCode;

	BookGameStatus(String message, int statusCode) {
		this.message = message;
		this.statusCode = statusCode;
	}

	public int getStatusCode() {
		return statusCode;
	}
}
