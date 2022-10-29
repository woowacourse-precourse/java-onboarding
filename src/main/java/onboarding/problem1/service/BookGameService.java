package onboarding.problem1.service;

import onboarding.problem1.domain.Page;

import java.util.List;

public class BookGameService {

    private static final int DRAW = 0;
    private static final int BEFORE_WIN = 1;
    private static final int AFTER_WIN = 2;
    private static final int EXCEPTION = -1;

    public static int result(List<Integer> beforeNumbers, List<Integer> afterNumbers) {
        try {
            Page before = new Page(beforeNumbers);
            Page after = new Page(afterNumbers);
            return result(before.maxScore(), after.maxScore());
        } catch (Exception exception) {
            return EXCEPTION;
        }
    }

    private static int result(int beforeScore, int afterScore) {
        if (beforeScore > afterScore) {
            return BEFORE_WIN;
        }
        if (beforeScore < afterScore) {
            return AFTER_WIN;
        }
        if (beforeScore == afterScore) {
            return DRAW;
        }
        return EXCEPTION;
    }
}
