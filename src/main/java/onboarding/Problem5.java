package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer= new ArrayList<Integer>();

        answer.add(money/50000);
        money%=50000;
        answer.add(money/10000);
        money%=10000;
        answer.add(money/5000);
        
        return answer;

    }
}