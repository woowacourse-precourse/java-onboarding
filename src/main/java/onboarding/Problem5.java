package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {

    private static final int MONEY_MIN = 1;
    private static final int MONEY_MAX = 1000000;

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    public static boolean checkMoneyValueValid(int money) {
        return MONEY_MIN <= money && money <= MONEY_MAX;
    }

}
