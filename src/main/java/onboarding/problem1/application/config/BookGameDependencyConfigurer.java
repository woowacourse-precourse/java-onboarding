package onboarding.problem1.application.config;

import onboarding.problem1.application.bookgame.BookGamePlayerService;
import onboarding.problem1.application.bookgame.BookGameScoreService;

public class BookGameDependencyConfigurer {

	public BookGamePlayerService playerService() {
		return new BookGamePlayerService();
	}

	public BookGameScoreService scoreService() {
		return new BookGameScoreService();
	};
}
