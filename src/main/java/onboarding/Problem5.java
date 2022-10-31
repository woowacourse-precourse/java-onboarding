package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = new ArrayList<>();
        int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for(int i=0; i<unit.length; i++){
            answer.add(money / unit[i]);
            money = money % unit[i];
        }
        return answer;
    }
}
