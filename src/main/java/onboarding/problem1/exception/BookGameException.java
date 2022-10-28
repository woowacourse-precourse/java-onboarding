package onboarding.problem1.exception;

import onboarding.problem1.application.bookgame.BookGameStatus;

public class BookGameException extends RuntimeException {
	private BookGameStatus status;

	public BookGameException(BookGameStatus status) {
		this.status = status;
	}

	public BookGameStatus getStatus() {
		return status;
	}

	public int getExceptionCode() {
		return status.getExceptionCode();
	}
}
