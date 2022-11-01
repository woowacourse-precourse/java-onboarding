package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        List<Integer> moneyArr = createMoneyArr();
        answer = seperateMoney(money, moneyArr);
        return answer;
    }

    // 각 금액 기준을 담은 배열 생성
    private static List<Integer> createMoneyArr() {
        return Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
    }

    // 금액 별로 돈 분리
    private static List<Integer> seperateMoney(int money, List<Integer> moneyArr) {
        List<Integer> result = new ArrayList<>();
        int moneyUnit;
        for (int i = 0; i < moneyArr.size(); i++) {
            moneyUnit = moneyArr.get(i);
            result.add(money / moneyUnit);
            money %= moneyUnit;
        }
        return result;
    }
}
