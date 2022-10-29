package onboarding.problem1.service;

import onboarding.problem1.domain.Page;

import java.util.List;

public class BookGameService {

    public int result(List<Integer> beforeNumbers, List<Integer> afterNumbers) {
        try {
            Page before = new Page(beforeNumbers.get(0), beforeNumbers.get(1));
            Page after = new Page(afterNumbers.get(0), afterNumbers.get(1));

            if (before.maxScore() > after.maxScore()) {
                return 1;
            }
            if (before.maxScore() < after.maxScore()) {
                return 2;
            }
            if (before.maxScore() == after.maxScore()) {
                return 0;
            }
        } catch (Exception exception) {
            return -1;
        }
        return -1;
    }
}
