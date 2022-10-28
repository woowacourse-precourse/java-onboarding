package onboarding.problem1.application.bookgame;

import static onboarding.problem1.Problem1Constant.*;

import java.util.List;

import onboarding.problem1.application.PlayerService;
import onboarding.problem1.model.Player;

public class BookGamePlayerService implements PlayerService {

	@Override
	public Player joinPlayer(List<Integer> infos) {
		Integer leftPage = infos.get(LEFT_PAGE_INDEX);
		Integer rightPage = infos.get(RIGHT_PAGE_INDEX);

		return new Player(leftPage, rightPage);
	}
}
