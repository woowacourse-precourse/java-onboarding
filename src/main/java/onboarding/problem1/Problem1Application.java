package onboarding.problem1;

import static onboarding.problem1.application.bookgame.BookGameStatus.*;

import java.util.List;

import onboarding.problem1.application.PlayerService;
import onboarding.problem1.application.ScoreService;
import onboarding.problem1.application.bookgame.BookGameStatus;
import onboarding.problem1.application.bookgame.BookGameValidation;
import onboarding.problem1.config.BookGameDependencyConfigurer;
import onboarding.problem1.model.Player;

public class Problem1Application {

	private final PlayerService playerService;
	private final ScoreService scoreService;

	public Problem1Application(BookGameDependencyConfigurer bookGameConfig) {
		this.playerService = bookGameConfig.playerService();
		this.scoreService = bookGameConfig.scoreService();
	}

	public void validateInput(List<Integer> pages1, List<Integer> pages2) {
		BookGameValidation bookGameValidation = new BookGameValidation();

		if (bookGameValidation.validate(pages1)
			&& bookGameValidation.validate(pages2)) {
		}

	}

	public int run(List<Integer> pages1, List<Integer> pages2) {
		Player player1 = playerService.joinPlayer(pages1);
		Player player2 = playerService.joinPlayer(pages2);

		int player1Score = scoreService.calculatePlayerScore(player1);
		int player2Score = scoreService.calculatePlayerScore(player2);

		return getResultCode(player1Score, player2Score);
	}

	private int getResultCode(final int pobiScore, final int crongScore) {
		BookGameStatus gameStatus = DRAW;

		if (pobiScore > crongScore) {
			gameStatus = WINNER_POBI;
		} else if (pobiScore < crongScore) {
			gameStatus = WINNER_CRONG;
		}

		return gameStatus.getStatusCode();
	}

}
