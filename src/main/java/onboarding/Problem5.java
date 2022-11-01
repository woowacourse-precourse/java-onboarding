package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    static int[] units = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {

        List<Integer> answer = new ArrayList<>();

        int moneyLeft = money;

        for (int unit : units) {
            int count = getMaxCountByUnit(moneyLeft, unit);
            answer.add(count);

            moneyLeft -= getTotalAmount(unit, count);
        }

        return answer;
    }

    public static int getTotalAmount(int unit, int count) {
        return unit * count;
    }

    public static int getMaxCountByUnit(int money, int unit) {
        return money / unit;
    }

}
