package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    private static final List<Integer> VALUES = Arrays.asList(
            50000, 10000, 5000, 1000, 500, 100, 50, 10, 1
    );

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(Collections.emptyList());
        for (Integer value : VALUES) {
            answer.add(money / value);
            money -= (money / value) * value;
        }
        return answer;
    }
}
