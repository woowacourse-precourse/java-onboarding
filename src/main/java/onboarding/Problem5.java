package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {

    private final static int MIN_RANGE_NUM = 1;
    private final static int MAX_RANGE_NUM = 1000000;

    public static List<Integer> solution(int money) {
        validateRange(money);

        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    private static void validateRange(int input) {
        if (input < MIN_RANGE_NUM || input > MAX_RANGE_NUM) {
            throw new IllegalArgumentException("1 이상 1000000 이하인 자연수를 입력하세요.");
        }
    }
}
