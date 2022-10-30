package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Bank.getMoneyCountList(money);
        return answer;
    }
}

class Bank {
    private static final int[] moneyArray = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    static List<Integer> getMoneyCountList(int money) {
        List<Integer> moneyCountList = new ArrayList<>();
        int countTimes = moneyArray.length;
        int count;
        int changes = money;
        for (int i = 0; i < countTimes; i++) {
            count = changes / moneyArray[i];
            changes = changes % moneyArray[i];
            moneyCountList.add(count);
        }
        return moneyCountList;
    }

}