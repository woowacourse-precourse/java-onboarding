package onboarding.problem1.config;

import onboarding.problem1.application.PlayerService;
import onboarding.problem1.application.ScoreService;
import onboarding.problem1.application.bookgame.BookGamePlayerService;
import onboarding.problem1.application.bookgame.BookGameScoreService;

public class BookGameDependencyConfigurer {

	private static PlayerService bookGamePlayerService;
	private static ScoreService bookGameScoreService;

	public PlayerService playerService() {
		if(bookGamePlayerService == null){
			bookGamePlayerService = new BookGamePlayerService();
		}
		return bookGamePlayerService;
	}

	public ScoreService scoreService() {
		if (bookGameScoreService == null) {
			bookGameScoreService = new BookGameScoreService();
		}
		return bookGameScoreService;
	}

}