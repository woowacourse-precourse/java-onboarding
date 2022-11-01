package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(Collections.emptyList());
        int[] currency = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        money = checkMoney(money);
        int currencyCount;
        int currentMoney = money;
        //유지보수 측면에서 기존 money 변수는 갱신하지 않음
        for (int i = 0; i < currency.length; i++) {
            currencyCount = currentMoney / currency[i];
            answer.add(i, currencyCount);
            currentMoney = currentMoney % currency[i];
        }
        return answer;
    }

    public static Integer checkMoney(int money) {
        if (money < 1 || money > 1_000_000) {
            throw new IllegalStateException("돈은 1원 이상, 100만원 이하여야 합니다.");
            //money는 1 이상 1,000,000 이하인 자연수이다.
        } else {
            return money;
        }
    }
}
