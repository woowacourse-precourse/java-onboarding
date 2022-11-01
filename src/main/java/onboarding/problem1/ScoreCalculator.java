package onboarding.problem1;

import java.util.List;

public class ScoreCalculator {
    public int getGameScore(GamePlayer gamePlayer1) {
        List<Integer> pages = gamePlayer1.getPages();
        return pages.stream().mapToInt(ScoreCalculator::findGreaterOfSumAndProduct).max().orElseThrow(IllegalArgumentException::new);
    }
}
