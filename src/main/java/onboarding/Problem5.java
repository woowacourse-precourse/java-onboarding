package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    public static final int[] moneyArray = {50000, 10000, 5000, 1000, 500, 100 ,50 ,10, 1};
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        calculate(money, answer);
        return answer;
    }

    private static void calculate(int calculatedMoney, List<Integer> answer) {
        for (int money : moneyArray) {
            int countMoney = calculatedMoney / money;
            answer.add(countMoney);
            calculatedMoney %= money;
        }
    }
}
