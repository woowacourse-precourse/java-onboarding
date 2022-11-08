package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private final static int[] UNIT = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < UNIT.length; i++) {
            int number = money / UNIT[i];
            answer.add(number);
            money = money - UNIT[i] * number;
        }
        return answer;
    }
}
