package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = new ArrayList<>();
        int[] typeOfMoney = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        countChanges(typeOfMoney, answer, money);

        return answer;
    }

    private static void countChanges(int[] typeOfMoney, List<Integer> answer, int money) {
        int balance = money;
        for (int i=0; i<typeOfMoney.length; i++) {
            int count = balance/typeOfMoney[i];
            if (count != 0) {
                balance -= count*typeOfMoney[i];
                answer.add(count);
                continue;
            }
            answer.add(0);
        }
    }
}
