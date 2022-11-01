package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    private final static List<Integer> moneyUnitList = List.of(
            50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1
    );

    public static List<Integer> solution(int money) {
        return reverMoneyToUnit(money);
    }

    public static List<Integer> reverMoneyToUnit(int money) {
        List<Integer> answer = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0, 0, 0, 0));

        int index = 0;
        for (int unit : moneyUnitList) {
            if (money >= unit) {
                answer.set(index, (int) money / unit);
                money -= ((int) money / unit) * unit;
            }
            index++;
        }
        return answer;
    }
}
