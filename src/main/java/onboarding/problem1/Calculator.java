package onboarding.problem1;

import java.util.List;

public class Calculator {

    private final List<Integer> pages;

    public Calculator(List<Integer> pages) {
        this.pages = pages;
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

    public int getScore() {
        int score = 0;
        int maxValue;
        for (int page : this.pages) {
            maxValue = Math.max(getSumValue(page), getMultipliedValue(page));
            score = Math.max(score, maxValue);
        }
        return score;
    }
}
