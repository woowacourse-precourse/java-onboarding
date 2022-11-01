package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] moneyArr = new int[] {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for(int i : moneyArr) {
            int charge = diviedMoney(money, i);
            answer.add(charge);
            money -= i * charge;
        }
        return answer;
    }
    private static int diviedMoney(int money, int unit) {
        return money / unit;
    }
}
