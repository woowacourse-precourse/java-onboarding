package onboarding.problem3.MatchGame;

import java.util.Set;

public class Match369Game extends MatchGame {
    private final static Set<Integer> matchNumbers = Set.of(3, 6, 9);

    public Match369Game() {
        super(matchNumbers);
    }
}
