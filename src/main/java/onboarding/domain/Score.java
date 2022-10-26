package onboarding.domain;

import java.util.List;

import static java.lang.Math.max;
import static onboarding.validator.PageNumberValidator.isValidPageNumbers;

public class Score {
    public static final int WIN = 1;
    public static final int LOSE = 2;
    public static final int DRAW = 0;

    private final int score;

    public Score(List<Integer> pageNumbers) {
        isValidPageNumbers(pageNumbers);
        this.score = calculateScore(pageNumbers);
    }

    private int calculateScore(List<Integer> pageNumbers) {
        return pageNumbers.stream()
                .mapToInt(pageNumber -> max(sumAllPageNumbers(pageNumber), multiAllPageNumbers(pageNumber)))
                .max().orElse(0);
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

    public int playGame(Score scoreForAnother) {
        if (lose(scoreForAnother)) {
            return LOSE;
        }
        if (win(scoreForAnother)) {
            return WIN;
        }
        return DRAW;
    }

    private boolean win(Score scoreForAnother) {
        return this.score > scoreForAnother.score;
    }

    private boolean lose(Score scoreForAnother) {
        return this.score < scoreForAnother.score;
    }
}
