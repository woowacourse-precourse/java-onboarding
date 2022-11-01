package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    public static List<Integer> solution(int money) {
        final int[] CURRENCIES = {50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1};

        final List<Integer> answer = new ArrayList<>(CURRENCIES.length);

        for (int currency : CURRENCIES) {
            answer.add(money / currency);
            money %= currency;
        }
        return answer;
    }

}
