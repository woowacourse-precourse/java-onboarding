package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] currencies = {50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1};

        for (int currency : currencies) {
            answer.add(money / currency);
            money %= currency;
        }
        return answer;
    }

}
