package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer  = new ArrayList<Integer>();

        int[] coin = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for (int i=0; i<coin.length; i++) {
            answer.add(i, money / coin[i]);
            money %= coin[i];
        }

        return answer;
    }
}
