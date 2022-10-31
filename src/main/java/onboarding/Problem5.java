package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = new ArrayList<>();

        int[] change_types = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        while(money > 0) {
            for(int c : change_types) {
                if(money >= c) {
                    int change_count = money / c;
                    answer.add(change_count);
                    money -= (c * change_count);
                }
                else answer.add(0);
            }
        }

        return answer;
    }
}
