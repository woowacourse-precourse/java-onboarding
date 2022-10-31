package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    static int calculateChange(int totalMoney, int money, int count) {
        if (count == 0) {
            return totalMoney;
        }

        return totalMoney % (money * count);
    }
}
