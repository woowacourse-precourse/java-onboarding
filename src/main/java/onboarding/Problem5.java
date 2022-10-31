package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        List<Integer> coins = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

        // 돈의 액수에 대한 각 화폐별 필요 반환 갯수를 구한다.
        for (Integer coin : coins) {
            answer.add(money / coin);
            money = money % coin;

        }

        return answer;
    }
}
