package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static final int[] MONEY_UNITS = new int[]{50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {

        List<Integer> answer = new ArrayList<>();
        int remainingMoney = money;
        for (int moneyUnit : MONEY_UNITS){
            int unitCount = remainingMoney / moneyUnit;
            answer.add(unitCount);
            remainingMoney -= moneyUnit * unitCount;
        }

        return answer;
    }
}
