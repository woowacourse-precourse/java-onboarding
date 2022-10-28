package onboarding.problem1;

import java.util.stream.Stream;

public class Game {

    private final Player firstPlayer;
    private final Player secondPlayer;

    public Game(final Player firstPlayer, final Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public boolean isValid() {
        return Stream.of(firstPlayer, secondPlayer)
            .allMatch(Player::isValid);
    }

    public Player getFirstPlayer() {
        return firstPlayer;
    }

    public Player getSecondPlayer() {
        return secondPlayer;
    }
}
