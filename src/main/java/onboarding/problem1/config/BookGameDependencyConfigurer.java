package onboarding.problem1.config;

import onboarding.problem1.application.bookgame.BookGamePlayerService;
import onboarding.problem1.application.bookgame.BookGameScoreService;
import onboarding.problem1.application.bookgame.BookGameValidation;

public class BookGameDependencyConfigurer {

	public BookGamePlayerService playerService() {
		return new BookGamePlayerService();
	}

	public BookGameScoreService scoreService() {
		return new BookGameScoreService();
	};

	public BookGameValidation validation() {
		return new BookGameValidation();
	}
}
