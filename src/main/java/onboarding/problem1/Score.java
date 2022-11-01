package onboarding.problem1;

import java.util.List;

public class Score {

    private static final int VALID_LENGTH = 2;
    private static final int VALID_DIFFERENCE = 1;
    private static final int VALID_MIN_RANGE = 3;
    private static final int VALID_MAX_RANGE = 398;
    private static final int LEFT_PAGE_INDEX = 0;
    private static final int RIGHT_PAGE_INDEX = 1;
    private final int leftPage;
    private final int rightPage;

    public Score(List<Integer> pages) {
        Score.validScore(pages);
        this.leftPage = pages.get(LEFT_PAGE_INDEX);
        this.rightPage = pages.get(RIGHT_PAGE_INDEX);
    }

    private static boolean hasValidLength(List<Integer> pages) {
        return pages.size() == VALID_LENGTH;
    }

    private static boolean hasValidNum(List<Integer> pages) {
        return pages.get(0) % 2 == 1 && pages.get(1) % 2 == 0;
    }

    private static boolean hasValidRange(List<Integer> pages) {
        for (int page : pages) {
            if (page > VALID_MAX_RANGE || page < VALID_MIN_RANGE) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasValidDifference(List<Integer> pages) {
        return pages.get(1) - pages.get(0) == VALID_DIFFERENCE;
    }

    private static void validScore(List<Integer> pages) {
        if (!hasValidLength(pages) || !hasValidNum(pages) || !hasValidDifference(pages) || !hasValidRange(pages)) {
            throw new IllegalArgumentException();
        }
    }

    private int getSumValue(int page) {
        int ans = 0;
        while (page > 0) {
            ans += page % 10;
            page /= 10;
        }
        return ans;
    }

    private int getMultipliedValue(int page) {
        int ans = 1;
        while (page > 0) {
            ans *= page % 10;
            page /= 10;
        }
        return ans;
    }

    public int getMaxScore() {
        int score = 0;
        int maxValue;
        for (int page : List.of(leftPage, rightPage)) {
            maxValue = Math.max(getSumValue(page), getMultipliedValue(page));
            score = Math.max(score, maxValue);
        }
        return score;
    }
}
