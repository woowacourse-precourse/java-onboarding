package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    static final int[] UNITS = {50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        return getResultUnitList(money);
    }

    private static List<Integer> getResultUnitList(int money) {
        List<Integer> answer = new ArrayList<>();
        int leftMoney = money;

        for (int unit : UNITS) {
            if (!isEnoughMoney(leftMoney, unit)) {
                answer.add(0);
                continue;
            }

            answer.add(getUnitCount(leftMoney, unit));
            leftMoney = getLeftMoney(leftMoney, unit);
        }

        return answer;
    }

    private static int getLeftMoney(int leftMoney, int unit) {
        leftMoney %= unit;
        return leftMoney;
    }

    private static int getUnitCount(int leftMoney, int unit) {
        int unitCount = leftMoney / unit;
        return unitCount;
    }

    private static boolean isEnoughMoney(int leftMoney, int unit) {
        return leftMoney >= unit;
    }
}
