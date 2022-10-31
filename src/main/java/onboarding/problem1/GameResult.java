package onboarding.problem1;

import java.util.Arrays;
import java.util.Objects;

public enum GameResult {
    POBI_WIN(GameStatus.POBI_WIN, 1),
    CRONG_WIN(GameStatus.CRONG_WIN, 2),
    DRAW(GameStatus.DRAW, 0),
    ERROR(GameStatus.ERROR, -1);

    private final GameStatus gameStatus;
    private final Integer result;

    GameResult(GameStatus gameStatus, Integer result) {
        this.gameStatus = gameStatus;
        this.result = result;
    }

    public static Integer of(GameStatus gameStatus) {

        return Arrays.stream(values())
            .filter(it -> Objects.equals(it.gameStatus, gameStatus))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new)
            .result;
    }
}
