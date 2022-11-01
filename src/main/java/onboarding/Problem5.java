package onboarding;

import java.util.Arrays;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Arrays.asList(new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0});
        List<Integer> change_list = Arrays.asList(new Integer[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1});

        for (int i = 0; i < 9; i++) {
            int change = change_list.get(i);
            answer.set(i, money / change);
            money %= change;
        }

        return answer;
    }
}
