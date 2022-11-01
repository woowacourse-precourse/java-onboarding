package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        int[] token = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        return countTokens(money, token);
    }
    private static List<Integer> countTokens(int money, int[] token) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < token.length; i++) {
            if (money > 0) {
                result.add(money / token[i]);
                money %= token[i];
            } else result.add(0);
        }
        return result;
    }
}