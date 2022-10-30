package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = MoneyCalculator.calculateMoney(money);
        return answer;
    }
}


class MoneyCalculator {

    private final static int[] MONETARY_UNIT_LIST
            = {50000,10000,5000,1000,500,100,50,10,1};

    public static List<Integer> calculateMoney(int money) {

        Integer[] resultArray = new Integer[MONETARY_UNIT_LIST.length];
        int change = money;

        for (int i = 0; i < MONETARY_UNIT_LIST.length; i++) {
            resultArray[i] = change / MONETARY_UNIT_LIST[i];
            change = change % MONETARY_UNIT_LIST[i];
        }

        return List.of(resultArray);
    }
}