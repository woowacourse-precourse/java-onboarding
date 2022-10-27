package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            int divMoney = getDivMoney(i, 50000);
            int moneyCount = getMoneyCount(money, divMoney);

            answer.add(moneyCount);
            money -= (divMoney * moneyCount);
        }

        return answer;
    }

    private static int getDivMoney(int depth, int money) {

        if (depth == 8) {
            return 1;
        }

        for (int i = 0; i < depth; i++) {

            if (i % 2 == 0) {
                money /= 5;
            } else {
                money /= 2;
            }

        }

        return money;
    }

    private static int getMoneyCount(int money, int divMoney) {

        return money / divMoney;
    }

}
