package onboarding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    static int[] moneys = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        int[] wallet = new int[9];
        for (int i = 0; i < 9; i++) {
            if (money < moneys[i]) continue;
            wallet[i] += money / moneys[i];
            money %= moneys[i];
        }
        return answer;
    }
}
