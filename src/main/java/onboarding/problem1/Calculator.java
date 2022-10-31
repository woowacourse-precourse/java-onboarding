package onboarding.problem1;

import java.util.ArrayList;
import java.util.List;

public class Calculator implements CalculatorInt {
    private final int score;

    public Calculator(Pages pages) {
        int leftScore = calculateScore(pages.getLeftPage());
        int rightScore = calculateScore(pages.getRightPage());

        if (leftScore > rightScore) {
            score = leftScore;
            return;
        }
        score = rightScore;
    }

    private int calculateScore(int page) {
        List<Integer> division = dividePage(page);
        CalculatorInt sumCalculator = new SumCalculator(division);
        CalculatorInt multipleCalculator = new SumCalculator(division);

        return Math.max(sumCalculator.getScore(), multipleCalculator.getScore());
    }

    private List<Integer> dividePage(int page) {
        List<Integer> division = new ArrayList<>();

        while (page > 0) {
            division.add(page % 10);
            page /= 10;
        }

        return division;
    }

    public int getScore() {
        return this.score;
    }
}
