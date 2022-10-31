package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        //List<Integer> answer = Collections.emptyList();
        List<Integer> answer = new ArrayList<>();
        int[] moneys = new int[] {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for (int i = 0; i < 9; i++){
            int value = money / moneys[i];
            answer.add(value);
            money %= moneys[i];
        }
        return answer;
    }
}
