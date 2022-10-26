package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = new ArrayList<>();
        int[] changes = {50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1};
        for(int change : changes){
            answer.add(money/change);
            money %= change;
        }
        return answer;
    }
}
