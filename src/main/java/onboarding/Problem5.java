package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] moneyTypes = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int moneyType : moneyTypes) {
            answer.add(money / moneyType);
            money = money % moneyType;
        }
        return answer;
    }

}
