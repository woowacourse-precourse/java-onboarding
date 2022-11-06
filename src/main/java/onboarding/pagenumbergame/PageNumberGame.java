package onboarding.pagenumbergame;

import static onboarding.pagenumbergame.GameResult.*;

import java.util.List;

public class PageNumberGame {

	private final Pages pobi;

	private final Pages crong;

	private int gameResult;

	public PageNumberGame(final List<Integer> player1,
		final List<Integer> player2) {

		validatePages(player1, player2);
		pobi = new Pages(player1);
		crong = new Pages(player2);
	}

	private void validatePages(final List<Integer> player1, final List<Integer> player2) {
		gameResult = NOT_DECIDED;

		if (isInvalidPage(player1) || isInvalidPage(player2)) {
			gameResult = EXCEPTION;
		}
	}

	private boolean isInvalidPage(final List<Integer> playerPages) {
		return !PageValidationUtils.validatePage(playerPages);
	}

	public int play() {
		if (gameResult == EXCEPTION) {
			return EXCEPTION;
		}
		int pobiScore = pobi.getScore();
		int crongScore = crong.getScore();

		if (pobiScore > crongScore) {
			return WIN;
		} else if (pobiScore == crongScore) {
			return DRAW;
		}
		return LOSE;
	}
}
