package onboarding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return changeMoney(money);
    }

    // 돈을 큰 화폐 순으로 리스트에 저장하고 리턴한다.
    private static List<Integer> changeMoney(int money) {
        int[] kindOfMoney = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < kindOfMoney.length; i++) {
            result.add(money / kindOfMoney[i]);
            money = money % kindOfMoney[i];
        }
        return result;
    }
}
