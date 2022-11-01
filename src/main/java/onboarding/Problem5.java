package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem5 {
    static HashMap<Integer, Integer> counter = new HashMap<>();

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> currencies = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

        for (int currency : currencies) {
            money = exchange(currency, money);
        }
        makeAnswer(answer, currencies);
        counter.clear();

        return answer;
    }

    public static int exchange(int currency, int money) {
        int count = 0;

        while (money >= currency) {
            money -= currency;
            count++;
        }
        updateCount(currency, count);
        return money;
    }

    public static void updateCount(int currency, int count) {
        counter.put(currency, count);
    }

    public static void makeAnswer(List<Integer> answer, List<Integer> currencies) {
        int count;

        for (int currency : currencies) {
            count = counter.get(currency);
            answer.add(count);
        }
    }
}
