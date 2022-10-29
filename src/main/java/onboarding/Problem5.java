package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem5 {
    static HashMap<Integer, Integer> counter;

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        counter = new HashMap<>();



        return answer;
    }

    public static void exchange(int currency, int money) {
        int count = 0;

        while (money >= currency) {
            money -= currency;
            count++;
        }
        updateCount(currency, money);
    }

    public static void updateCount(int currency, int count) {
        counter.put(currency, count);
    }

}
