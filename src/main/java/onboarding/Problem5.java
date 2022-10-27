package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    private final static int[] UNIT = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }
    private static int getNumOfBillsOrCoins(int i, int money) {
        return money / UNIT[i];
    }
    private static int change(int i, int number, int money) {
        return money - UNIT[i] * number;
    }
}
