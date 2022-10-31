package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        int[] moneyValue = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int i = 0; i < moneyValue.length; i++) {
            int numberOfMoney = money / moneyValue[i];
            answer.add(numberOfMoney);
            money %= moneyValue[i];
        }

        return answer;
    }

}