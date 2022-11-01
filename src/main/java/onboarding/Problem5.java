package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    static final List<Integer> typeOfMoney = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        for (int unit : typeOfMoney) {
            answer.add(countMoney(money, unit));
            money = balanceMoney(money, unit);
        }
        return answer;
    }
    private static int countMoney(int money, int won) {
        return money / won;
    }
    private static int balanceMoney(int money, int won) {
        return money % won;
    }
}
