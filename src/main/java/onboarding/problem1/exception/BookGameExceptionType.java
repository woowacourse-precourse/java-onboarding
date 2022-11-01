package onboarding.problem1.exception;

public enum BookGameExceptionType {

	/**
	 * 예외 케이스
	 * 1. 페이지를 벗어난 숫자가 입력된 경우
	 * 2. 왼쪽 페이지가 홀수가 아닌 경우
	 * 3. 오른쪽 페이지가 짝수가 아닌 경우
	 * 4. 연속된 페이지가 아닌 경우
	 */

	PAGE_OUT_OF_RANGE,
	LEFT_PAGE_NOT_ODD,
	RIGHT_PAGE_NOT_EVEN,
	PAGE_NOT_CONTINUOUS;
}
