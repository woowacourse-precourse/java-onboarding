package onboarding.problem1;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.BiPredicate;

public enum GameStatus {

    POBI_WIN((pobi, crong) -> pobi > crong),
    CRONG_WIN((pobi, crong) -> pobi < crong),
    DRAW(Objects::equals),
    ERROR((pobi, crong) -> false);

    private final BiPredicate<Integer, Integer> policy;

    GameStatus(final BiPredicate<Integer, Integer> policy) {
        this.policy = policy;
    }

    public static GameStatus of(final Game game) {

        return game.isValid() ? findResultOf(game) : GameStatus.ERROR;
    }

    private static GameStatus findResultOf(final Game game) {

        return Arrays.stream(values())
            .filter(status -> status.hasPolicyMatchedTo(game))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }

    private boolean hasPolicyMatchedTo(final Game game) {

        Player firstPlayer = game.getFirstPlayer();
        Player secondPlayer = game.getSecondPlayer();

        return policy.test(
            firstPlayer.calculatePoint(),
            secondPlayer.calculatePoint()
        );
    }
}
