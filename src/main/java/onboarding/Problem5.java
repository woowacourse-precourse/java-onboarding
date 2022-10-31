package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer;

        answer = moneyCalculator(money);
        return answer;
    }

    // 돈 개수 계산 메서드
    public static List<Integer> moneyCalculator(int money) {
        List<Integer> answer = new ArrayList<>();
        // [5만,1만,5천,1천,5백,1백,50,10,1]
        int[] moneyList = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for (int i = 0; i < moneyList.length; i++) {
            answer.add(i, money / moneyList[i]);
            money %= moneyList[i];
        }
        return answer;
    }
}
