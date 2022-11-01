package onboarding.problem3;

import onboarding.problem3.MatchGame.Match369Game;

import java.util.stream.IntStream;

public class Match369RangeGame{
    private final Match369Game match369Game = new Match369Game();

    public int getMatchRangeCount(int startInclusive, int endExclusive) {
        validateRange(startInclusive, endExclusive);

        return IntStream.range(startInclusive, endExclusive+1)
                .reduce(0, (total, num) -> total + match369Game.getMatchCount(num));
    }

    private void validateRange(int startInclusive, int endExclusive) throws IllegalArgumentException {
        if (!(1<=startInclusive && endExclusive <= 10_000)) {
            throw new IllegalArgumentException("startInclusive는 1보다 같거나 커야하고 endExclusive는 10,000보다 작거나 같아야 합니다.");
        }

        if (startInclusive > endExclusive) {
            throw new IllegalArgumentException("startInclusive의 값은 endExclusive보다 작아야 합니다.");
        }
    }
}
