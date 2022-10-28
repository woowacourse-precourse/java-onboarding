package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    private static int getUnits(int remainder, int moneyUnit) {
        return remainder / moneyUnit;
    }

    private static int withdraw(int units, int moneyUnit) {
        int withdrawnMoney = units * moneyUnit;
        return withdrawnMoney;
    }

}
