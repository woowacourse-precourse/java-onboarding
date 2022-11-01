package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    private static final int[] PAPER_MONEY = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int idx = 0;
        int count = 0;
        while (idx < 9) {
            if (money / PAPER_MONEY[idx] == 0) {
                answer.add(count);
                count = 0;
                money %= PAPER_MONEY[idx];
                idx++;
                continue;
            }
            count++;
            money -= PAPER_MONEY[idx];
        }
        return answer;
    }
}
