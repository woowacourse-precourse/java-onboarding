package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> wons = Arrays.asList(50_000,10_000,5_000,1_000,500,100,50,10,1);
        for (int won : wons) {
            answer.add(money/won);
            money%=won;
        }

        return answer;
    }
}
