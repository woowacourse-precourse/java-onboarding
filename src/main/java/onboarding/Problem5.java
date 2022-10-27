package onboarding;

import java.util.*;

public class Problem5 {
    static final int[] currency = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    static final int totalLen = 9;
    static List<Integer> result;

    public static void transformer(int money) {
        int quotient;
        for (int i = 0; i < totalLen; i++) {
            quotient = (int) money / currency[i];
            result.add(quotient);
            money -= quotient * currency[i];
        }
    }

    public static List<Integer> solution(int money) {
//        List<Integer> answer = Collections.emptyList();
        result = new ArrayList<>();
        transformer(money);
        return result;
    }
}
