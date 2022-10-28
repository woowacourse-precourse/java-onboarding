package onboarding.problem1.config;

import onboarding.problem1.application.bookgame.BookGamePlayerService;
import onboarding.problem1.application.bookgame.BookGameScoreService;

public class BookGameDependencyConfigurer {

	private static BookGamePlayerService bookGamePlayerService;
	private static BookGameScoreService bookGameScoreService;

	public BookGamePlayerService playerService() {
		if(bookGamePlayerService == null){
			bookGamePlayerService = new BookGamePlayerService(scoreService());
		}
		return bookGamePlayerService;
	}

	public BookGameScoreService scoreService() {
		if (bookGameScoreService == null) {
			bookGameScoreService = new BookGameScoreService();
		}
		return bookGameScoreService;
	}

}