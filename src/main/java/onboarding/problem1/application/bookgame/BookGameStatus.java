package onboarding.problem1.application.bookgame;

import static onboarding.problem1.Problem1Constant.*;

public enum BookGameStatus {
	/**
	 * 예외 케이스
	 * 1. 페이지를 벗어난 숫자가 입력된 경우
	 * 2. 왼쪽 페이지가 홀수가 아닌 경우
	 * 3. 오른쪽 페이지가 짝수가 아닌 경우
	 * 4. 연속된 페이지가 아닌 경우
	 */

	PAGE_OUT_OF_RANGE("페이지를 벗어난 숫자 입니다.", EXCEPTION_CODE),
	LEFT_PAGE_NOT_ODD("왼쪽 페이지는 홀수이어야 합니다", EXCEPTION_CODE),
	RIGHT_PAGE_NOT_EVEN("오른쪽 페이지는 짝수이어야 합니다", EXCEPTION_CODE),
	PAGE_NOT_CONTINUOUS("페이지는 연속된 숫자이어야 합니다", EXCEPTION_CODE);

	private final String message;
	private final int exceptionCode;

	BookGameStatus(String message, int exceptionCode) {
		this.message = message;
		this.exceptionCode = exceptionCode;
	}

	public int getExceptionCode() {
		return exceptionCode;
	}
}
