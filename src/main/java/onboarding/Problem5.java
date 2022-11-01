package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static final int[] bills = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList <>();

        for(int item : bills){
            answer.add(money / item);
            money %= item;
        }

        return answer;
    }
}
