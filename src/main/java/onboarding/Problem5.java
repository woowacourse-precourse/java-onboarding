package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static final int[] MONEY_LIST = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    private static int getMoneyCount(int money, int index) {
        int count = 0;
        if (money / MONEY_LIST[index] >= 1) {
            count = money / MONEY_LIST[index];
        }
        return count;
    }

    private static int getChangeMoney(int money, int index, int count) {
        int changeMoney = 0;
        changeMoney = money - (MONEY_LIST[index] * count);
        return changeMoney;
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < MONEY_LIST.length; i++) {
            answerList.add(getMoneyCount(money, i));
            money = getChangeMoney(money, i, answerList.get(i));
        }

        answer = answerList;

        return answer;
    }
}
