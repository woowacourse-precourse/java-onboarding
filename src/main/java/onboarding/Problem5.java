package onboarding;

import java.util.ArrayList;
import java.util.List;

/*
1. 큰 금액부터 차례로 나누기
2. 변환된 돈 개수 구하기
 */

public class Problem5 {

    private static List<Integer> getCoins(int money) {
        List<Integer> coins = new ArrayList<>();
        int[] elements = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for (int element : elements) {
            coins.add(money / element);
            money = money % element;
        }
        return coins;
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        answer = getCoins(money);
        return answer;
    }
}
