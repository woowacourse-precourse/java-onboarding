package onboarding;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.BiPredicate;

public enum GameStatus {

    POBI_WIN((pobi, crong) -> pobi > crong, 1),
    CRONG_WIN((pobi, crong) -> pobi < crong, 2),
    DRAW(Objects::equals, 0),
    ERROR((pobi, crong) -> false, -1);

    private final BiPredicate<Integer, Integer> policy;
    private final Integer point;

    GameStatus(final BiPredicate<Integer, Integer> policy, final Integer point) {
        this.policy = policy;
        this.point = point;
    }

    public static GameStatus of(final Game game) {

        return Arrays.stream(values())
            .filter(status -> status.isResultOf(game))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }

    private boolean isResultOf(final Game game) {
        Player firstPlayer = game.getFirstPlayer();
        Player secondPlayer = game.getSecondPlayer();

        return policy.test(firstPlayer.calculatePoint(), secondPlayer.calculatePoint());
    }

    public int getResult(){
        return this.point;
    }
}
