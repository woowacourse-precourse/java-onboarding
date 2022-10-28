package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static final int[] UNITS = {50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        if (checkInput(money)) {
            answer.add(-1);
            return answer;
        }

        return changeUnit(money, answer);
    }

    public static boolean checkInput(int money) {
        if (money < 1 || money > 1_000_001) {
            return true;
        }
        return false;
    }

    private static List<Integer> changeUnit(int money, List<Integer> answer) {

        for (int unit : UNITS) {
            answer.add(money / unit);
            money %= unit;
        }
        return answer;
    }
}
