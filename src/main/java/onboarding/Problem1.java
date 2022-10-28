package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        GameStatus gameStatus = execute(pobi, crong);
        return gameStatus.getResult();
    }

    private static GameStatus execute(List<Integer> firstPlayer, List<Integer> secondPlayer) {

        Game game = new Game(Player.from(firstPlayer), Player.from(secondPlayer));

        if (game.isValid()) {
            return GameStatus.of(game);
        }
        return GameStatus.ERROR;
    }
}
