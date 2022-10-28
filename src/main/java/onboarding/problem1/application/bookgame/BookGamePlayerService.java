package onboarding.problem1.application.bookgame;

import static onboarding.problem1.Problem1Constant.*;

import java.util.List;

import onboarding.problem1.application.PlayerService;
import onboarding.problem1.application.ScoreService;
import onboarding.problem1.model.Player;

public class BookGamePlayerService implements PlayerService {
	private final ScoreService scoreService;

	public BookGamePlayerService(ScoreService scoreService) {
		this.scoreService = scoreService;
	}

	@Override
	public Player joinPlayer(List<Integer> infos) {
		Integer leftPage = infos.get(LEFT_PAGE_INDEX);
		Integer rightPage = infos.get(RIGHT_PAGE_INDEX);

		return new Player(leftPage, rightPage);
	}
}
