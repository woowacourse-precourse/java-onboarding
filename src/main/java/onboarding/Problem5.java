package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    static int[] priceMenu = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    static int MAX_SIZE = 9;

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(MAX_SIZE);

        for (Integer price : priceMenu) {
            int count = money / price;
            money %= price;
            answer.add(count);
        }
        return answer;
    }
}
