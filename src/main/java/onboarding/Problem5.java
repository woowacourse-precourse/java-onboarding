package onboarding;

import java.util.Arrays;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0);
        List<Integer> currencyUnit = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        int i = 0;

        //1. 나머지가 0이 될 때 까지 큰 금액 순서대로 나누어 몫은 result에 저장하는 기능
        for (int x : currencyUnit) {
            if (money > 0) {
                answer.set(i, money/x);
                money %= x;
                i++;
            }
        }

        return answer;
    }
}
