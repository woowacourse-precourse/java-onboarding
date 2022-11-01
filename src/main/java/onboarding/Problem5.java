package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        int[] cashUnits = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        List<Integer> answer = computeAnswer(cashUnits, money);
        return answer;
    }

    private static List<Integer> computeAnswer(int[] cashUnits, int money) {
        List<Integer> ret = new ArrayList<>();
        int rest = money;

        for (int unit : cashUnits) {
            ret.add(rest / unit);
            rest = rest % unit;
        }

        return ret;
    }
}
