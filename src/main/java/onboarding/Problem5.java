package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static final int MONEY_TYPE = 9;
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(MONEY_TYPE);

        int[] coinTypes = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int coin : coinTypes) {
            answer.add(money / coin);
            money %= coin;
        }

        return answer;
    }

}
