package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    private List<Integer> values = Arrays.asList(
            50_000,
            10_000,
            5_000,
            1_000,
            500,
            100,
            50,
            10,
            1);

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        getMoneysCounts(money, answer);

        return answer;
    }

    private static void getMoneysCounts(int money, List<Integer> answer) {

    }

    private static int getMoneyCounts(int money, List<Integer> answer, int value) {
        answer.add(money / value);
        return money & value;
    }
}
