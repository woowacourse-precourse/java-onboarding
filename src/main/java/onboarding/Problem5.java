package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> Currency=Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        List<Integer> answer = new ArrayList<>();
        for(Integer curr:Currency){
            int curr_int = curr;
            answer.add(money/curr_int);
            money %= curr_int;
        }
        return answer;
    }
}
