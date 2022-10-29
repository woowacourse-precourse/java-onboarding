package onboarding;

import java.util.ArrayList;
import java.util.List;

/**
 * 구현 순서
 * 1. 큰 단위 순서대로 금액의 몫과 나머지를 구한다.
 * 2. 나머지에 대해 다음으로 큰 단위의 몫과 나머지를 구한다.
 * 3. (1.)과 (2.) 과정을 반복한다.
 */
public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = changeMoney(money);
        return answer;
    }

    private static List<Integer> changeMoney(int money) {
        int[] moneyUnit = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 1 };
        List<Integer> changedMoney = new ArrayList<>();
        for (int i = 0; i < moneyUnit.length; i++) {
            changedMoney.add(money / moneyUnit[i]);
            money %= moneyUnit[i];
        }
        return changedMoney;
    }
}
