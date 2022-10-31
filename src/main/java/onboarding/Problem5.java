package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] units = {50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1};
        int tmp;
        for(int unit : units){
            tmp = money / unit;
            answer.add(tmp);
            money %= unit;
        }
        return answer;
    }
}
