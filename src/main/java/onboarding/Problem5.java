package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();

        int[] monetary_unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for(int i=0; i<monetary_unit.length; i++){
            answer.add(money/monetary_unit[i]);
            money %= monetary_unit[i];
        }

        return answer;
    }
}
