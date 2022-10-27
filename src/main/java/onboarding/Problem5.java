package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(Collections.emptyList());
        int[] currency = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int currencyCount;
        int currentMoney = money;
        for (int i = 0; i < currency.length; i++) {
            currencyCount = currentMoney / currency[i];
            answer.add(i, currencyCount);
            currentMoney = currentMoney % currency[i];
        }
        return answer;
    }
}
