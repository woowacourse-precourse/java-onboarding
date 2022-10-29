package onboarding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        int [] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        Integer [] result = new Integer[unit.length];
        int idx=0;

        for(int n: unit){
            result[idx]= money/n;
            money %= n;
            idx++;
        }


        return answer;
    }
}
