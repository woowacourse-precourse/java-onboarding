package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static final int[] KRW = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = countKRW(money);
        return answer;
    }

    public static List<Integer> countKRW(int money) {
        int len = KRW.length;
        List<Integer> counter = new ArrayList<>(len);
        for (int i = 0; i < len; ++i) {
            counter.add(money / KRW[i]);
            money = money % KRW[i];
        }
        return counter;
    }
}
