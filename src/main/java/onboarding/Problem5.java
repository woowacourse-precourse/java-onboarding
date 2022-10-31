package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();
        int coins[] = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for(int coinsIterator = 0; coinsIterator < 9; coinsIterator++) {
            answer.add(Integer.valueOf(money / coins[coinsIterator]));
            money %= coins[coinsIterator];
        }

        return answer;
    }
}
