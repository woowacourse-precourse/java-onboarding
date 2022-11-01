package onboarding.problem1;

import java.util.*;

public class ScoreCalculator {
    public int getGameScore(GamePlayer gamePlayer1) {
        List<Integer> pages = gamePlayer1.getPages();
        return pages.stream().mapToInt(ScoreCalculator::findGreaterOfSumAndProduct).max().orElseThrow(IllegalArgumentException::new);
    }

    private static int findGreaterOfSumAndProduct(int page) {
        int sumOfPage = 0;
        int multipliedPage = 1;
        while (page != 0) {
            int units = page % 10;
            sumOfPage += units;
            multipliedPage *= units;
            page /= 10;
        }
        return Math.max(sumOfPage, multipliedPage);
    }
}
