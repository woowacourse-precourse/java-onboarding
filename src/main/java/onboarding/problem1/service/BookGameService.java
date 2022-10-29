package onboarding.problem1.service;

import onboarding.problem1.domain.Page;

import java.util.List;

public class BookGameService {

    public static int result(List<Integer> beforeNumbers, List<Integer> afterNumbers) {
        try {
            Page before = new Page(beforeNumbers);
            Page after = new Page(afterNumbers);
            return result(before.maxScore(), after.maxScore());
        } catch (Exception exception) {
            return -1;
        }
    }

    private static int result(int beforeScore, int afterScore) {
        if (beforeScore > afterScore) {
            return 1;
        }
        if (beforeScore < afterScore) {
            return 2;
        }
        if (beforeScore == afterScore) {
            return 0;
        }
        return -1;
    }
}
