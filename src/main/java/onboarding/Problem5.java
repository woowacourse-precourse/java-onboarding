package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        // 화폐 종류
        int[] currency = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 1 };

        for (int i = 0; i < currency.length; ++i) {
            int number = money / currency[i];
            money %= currency[i];
            answer.add(number);
        }

        return answer;
    }
}
