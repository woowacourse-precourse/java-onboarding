package onboarding.problem1.exception;

import static onboarding.problem1.Problem1Constant.*;

public class BookGameException extends RuntimeException {
	private final BookGameExceptionType exceptionType;

	public BookGameException(BookGameExceptionType exceptionType) {
		this.exceptionType = exceptionType;
	}

	public int getExceptionCode() {
		return EXCEPTION_CODE;
	}
}
