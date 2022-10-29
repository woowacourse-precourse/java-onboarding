package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static final List<Integer> coinsAndBills = List.of(50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1);
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        for (int coinOrBill : coinsAndBills) {
            answer.add(money / coinOrBill);
            money %= coinOrBill;
        }

        return answer;
    }
}