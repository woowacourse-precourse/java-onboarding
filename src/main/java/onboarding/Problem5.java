package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = calculate(money);
        return answer;
    }

    /** 가장 단위가 큰 금액순으로 개수를 구하고 money에서 그만큼 빼는 과정을 반복하여 답을 구합니다. */
    private static List<Integer> calculate(int money) {
        Integer[] moneyTypes = {50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1};
        Integer[] result = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i=0;i<9;i++) {
            result[i] = money/moneyTypes[i];
            money = money - result[i]*moneyTypes[i];
        }

        return List.of(result);
    }
}
