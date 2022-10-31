package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> cash = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

        for (int c : cash) {
            answer.add((int) (money / c));
            money %= c;
        }

        return answer;
    }
}
