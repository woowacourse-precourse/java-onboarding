package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {

        List<Integer> answer = new ArrayList<>();

        int[] coins = new int[] {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for(Integer coin : coins) {
            answer.add(calculateMoney(money, coin));
            money %= coin;
        }

        return answer;
    }

    public static int calculateMoney(int money, int coin) {

        return money / coin;
    }
}
