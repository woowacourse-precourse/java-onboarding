package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    private final static int MIN_RANGE_NUM = 1;
    private final static int MAX_RANGE_NUM = 1000000;
    private final static int[] UNIT = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        validateRange(money);

        List<Integer> answer = withdraw(money);
        return answer;
    }

    private static List<Integer> withdraw(int money) {
        List<Integer> answer = new ArrayList<>(9);
        int WithdrawalAmount = money;

        for (int unit : UNIT) {
            answer.add(WithdrawalAmount / unit);
            WithdrawalAmount %= unit;
        }
        return answer;
    }

    private static void validateRange(int input) {
        if (input < MIN_RANGE_NUM || input > MAX_RANGE_NUM) {
            throw new IllegalArgumentException("1 이상 1000000 이하인 자연수를 입력하세요.");
        }
    }
}
