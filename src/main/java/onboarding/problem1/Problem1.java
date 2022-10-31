package onboarding.problem1;

import java.util.List;

public class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        Game game = new Game(
            Player.from(pobi),
            Player.from(crong)
        );

        GameStatus gameStatus = GameStatus.of(game);

        return GameResult.of(gameStatus);
    }
}
