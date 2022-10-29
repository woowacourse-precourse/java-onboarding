package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static int[] currencyUnits = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 1 };
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        //최대한 큰 금액의 지페 위주로 담자.
        int leftMoney = money;
        int count;

        for (int i = 0; i < currencyUnits.length; i++) {
            count = leftMoney / currencyUnits[i];
            answer.add(count);
            leftMoney %= currencyUnits[i];
        }

        return answer;
    }
}
