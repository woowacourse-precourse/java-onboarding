package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    private static final List<Integer> coins = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }


    // 매개변수에서 지폐, 동전이 각 몇 개로 변환되는지 반환하는 메소드
    private static ArrayList<Integer> coinsCount(int money) {
        int coinCount;
        ArrayList<Integer> coinsCount = new ArrayList<>();

        for (Integer coin : coins) {
            if (money == 0) {
                break;
            }
            coinCount = money / coin;
            money %= coin;
            coinsCount.add(coinCount);
        }
        return coinsCount;

    }

}