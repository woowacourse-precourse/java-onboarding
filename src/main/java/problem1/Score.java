package problem1;

import java.util.*;

public class Score {
    private final int leftPage;
    private final int rightPage;

    public Score(List<Integer> pages) {
        this.leftPage = pages.get(0);
        this.rightPage = pages.get(1);
    }

    public int getMaxScore() {
        int leftMaxScore = getMaxSumAndMultiply(leftPage);
        int rightMaxScore = getMaxSumAndMultiply(rightPage);
        return Math.max(leftMaxScore, rightMaxScore);
    }

    private int getMaxSumAndMultiply(int page) {
        int sum = 0;
        int multiply = 1;
        String stringPage = String.valueOf(page);

        for (int i = 0; i < stringPage.length(); i++) {
            int number = Integer.parseInt(stringPage.substring(i, i+1));
            sum += number;
            multiply *= number;
        }
        return Math.max(sum, multiply);
    }
}
