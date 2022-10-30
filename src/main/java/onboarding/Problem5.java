package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        return getChangeUnits(money);
    }

    private static List<Integer> getChangeUnits(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] changes = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int change : changes) {
            answer.add(money / change);
            money %= change;
        }

        return answer;
    }
}
