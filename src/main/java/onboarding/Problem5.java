package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        List<Integer> coinList = new ArrayList<>(List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1));

        for (Integer coin : coinList) {
            int coinNum = money / coin;
            answer.add(coinNum);
            money -= coin * coinNum;
        }

        return answer;
    }
}
