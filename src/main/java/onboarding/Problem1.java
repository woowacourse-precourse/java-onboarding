package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        GameStatus gameStatus = playGame(pobi, crong);

        return gameStatus.getResult();
    }

    private static GameStatus playGame(List<Integer> firstPlayer, List<Integer> secondPlayer) {

        Game game = new Game(
            Player.from(firstPlayer),
            Player.from(secondPlayer)
        );

        return GameStatus.of(game);
    }
}
