package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    private static final List<Integer> ERROR = Collections.emptyList();
    private static final List<Integer> MONEY_INDEX = List
        .of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
    private static final int MIN_MONEY = 0;
    private static final int MAX_MONEY = 1000000;

    public static List<Integer> solution(int money) {
        List<Integer> answer;

        if (Exception(money)) {
            return ERROR;
        }

        answer = cashCount(money);

        return answer;
    }

    private static boolean Exception(int money) {
        return (MIN_MONEY < money && money < MAX_MONEY) ? false : true;
    }

    private static int getMoneyType(int money) {
        int result = 0;

        for (Integer moneyIndex : MONEY_INDEX) {
            if (money >= moneyIndex) {
                result = moneyIndex;
                break;
            }
        }
        return result;
    }

    private static List<Integer> cashCount(int money) {
        List<Integer> result = new ArrayList<>(
            Collections.nCopies(MONEY_INDEX.size(), MIN_MONEY)
        );
        int moneyType;
        int moneyIndex;
        int prevVal;

        while (money > 0) {
            moneyType = getMoneyType(money);
            moneyIndex = MONEY_INDEX.indexOf(moneyType);
            prevVal = result.get(moneyIndex);
            result.set(moneyIndex, prevVal + 1);
            money -= moneyType;
        }
        return result;
    }


}
