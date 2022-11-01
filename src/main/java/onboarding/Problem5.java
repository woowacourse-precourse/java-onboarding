package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    final static int[] BASE_MONEY = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        for (int idx=0; idx<BASE_MONEY.length; idx++) {
            answer.add(money / BASE_MONEY[idx]);
            money%=BASE_MONEY[idx];
        }
        return answer;
    }
}
