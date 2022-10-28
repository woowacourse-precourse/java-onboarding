package onboarding.problem1;

import java.util.List;

import onboarding.problem1.application.PlayerService;
import onboarding.problem1.application.ScoreService;
import onboarding.problem1.application.Validation;
import onboarding.problem1.config.BookGameDependencyConfigurer;
import onboarding.problem1.exception.BookGameException;
import onboarding.problem1.model.Player;

public class Problem1Application {

	private final PlayerService playerService;
	private final ScoreService scoreService;
	private final Validation validation;

	public Problem1Application(BookGameDependencyConfigurer bookGameConfig) {
		this.playerService = bookGameConfig.playerService();
		this.scoreService = bookGameConfig.scoreService();
		this.validation = bookGameConfig.validation();
	}

	public int play(List<Integer> pages1, List<Integer> pages2) {
		if (validateBookGame(pages1, pages2)) {

		}
		if (bookGameException != null)
			return bookGameException;

		Player player1 = playerService.joinPlayer(pages1);
		Player player2 = playerService.joinPlayer(pages2);
	}

	private boolean validateBookGame(List<Integer> pages1, List<Integer> pages2) {
		try {
			validation.validate(pages1);
			validation.validate(pages2);
		} catch (BookGameException bookGameException) {
			return false;
		}

		return true;
	}

}
