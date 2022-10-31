package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        int[] moneyUnit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        int restMoney = money;

        if (restMoney >= 1) {
            for (int mon:moneyUnit) {
                int moneyNum = 0;
                moneyNum = restMoney / mon;
                answer.add(moneyNum);
                restMoney = restMoney % mon;
            }
        } else {
            throw new RuntimeException("1 이상 입력해야합니다.");
        }

        return answer;
    }
}
