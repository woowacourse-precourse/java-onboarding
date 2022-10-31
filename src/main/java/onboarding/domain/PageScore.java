package onboarding.domain;

import java.util.List;

import static java.lang.Math.max;
import static onboarding.validator.PageNumberValidator.CANNOT_GET_MAX_VALUE_ERROR;
import static onboarding.validator.PageNumberValidator.isValidPageNumbers;

public class PageScore {
    private static final int WIN = 1;
    private static final int LOSE = 2;
    private static final int DRAW = 0;

    private final int score;

    public PageScore(List<Integer> pageNumbers) {
        isValidPageNumbers(pageNumbers);
        this.score = calculateScore(pageNumbers);
    }

    private int calculateScore(List<Integer> pageNumbers) {
        return pageNumbers.stream()
                .mapToInt(this::calculateSinglePageScore)
                .max().orElseThrow(() -> new IllegalArgumentException(CANNOT_GET_MAX_VALUE_ERROR));
    }

    private int calculateSinglePageScore(Integer pageNumber) {
        return max(sumAllPageNumbers(pageNumber), multiAllPageNumbers(pageNumber));
    }

    private int sumAllPageNumbers(Integer pageNumber) {
        int score = 0;
        while (pageNumber != 0) {
            score += pageNumber % 10;
            pageNumber /= 10;
        }
        return score;
    }

    private int multiAllPageNumbers(Integer pageNumber) {
        int score = 1;
        while (pageNumber != 0) {
            score *= pageNumber % 10;
            pageNumber /= 10;
        }
        return score;
    }

    public int compareTo(PageScore scoreForAnother) {
        if (lose(scoreForAnother)) {
            return LOSE;
        }
        if (win(scoreForAnother)) {
            return WIN;
        }
        return DRAW;
    }

    private boolean win(PageScore scoreForAnother) {
        return this.score > scoreForAnother.score;
    }

    private boolean lose(PageScore scoreForAnother) {
        return this.score < scoreForAnother.score;
    }
}
