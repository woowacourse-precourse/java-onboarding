package onboarding;

import java.util.*;

public class Problem5 {

    private static final List<Integer> MONETARY_UNITS = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

    public static List<Integer> solution(int money) {
        return monetaryClassifier(money);
    }

    private static List<Integer> monetaryClassifier(int money) {
        Map<Integer, Integer> classifier = new LinkedHashMap<>();
        int temp = money;
        for (int i : MONETARY_UNITS) {
            classifier.put(i, temp / i);
            temp %= i;
        }
        return new ArrayList<>(classifier.values());
    }
}
