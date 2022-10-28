package onboarding.problem1.application.bookgame;

import static onboarding.problem1.Problem1Constant.*;
import static onboarding.problem1.application.bookgame.BookGameStatus.*;

import java.util.List;

import onboarding.problem1.application.Validation;
import onboarding.problem1.exception.BookGameException;

public class BookGameValidation implements Validation {


	@Override
	public boolean isValid(List<Integer> infos) throws BookGameException {
		Integer leftPage = infos.get(LEFT_PAGE_INDEX);
		Integer rightPage = infos.get(RIGHT_PAGE_INDEX);

		validateRange(leftPage, rightPage);
		validateOdd(leftPage);
		validateEven(rightPage);
		validateContinuous(leftPage, rightPage);

		return true;
	}

	private void validateRange(Integer leftPage, Integer rightPage) {
		isInRange(leftPage);
		isInRange(rightPage);
	}

	private void isInRange(int page) {
		if (page < MIN_PAGE || page > MAX_PAGE) {
			throw new BookGameException(PAGE_OUT_OF_RANGE);
		}
	}

	private void validateOdd(int page) {
		if (page % 2 != 1) {
			throw new BookGameException(LEFT_PAGE_NOT_ODD);
		}
	}

	private void validateEven(int page) {
		if (page % 2 != 0) {
			throw new BookGameException(RIGHT_PAGE_NOT_EVEN);
		}
	}

	private void validateContinuous(int a, int b) {
		if (b - a != 1) {
			throw new BookGameException(RIGHT_PAGE_NOT_EVEN);
		}
	}
}
