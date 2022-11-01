package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        //List<Integer> answer = Collections.emptyList(); // unsupport operation 예외-> Empty list 가 빈 list 사용할 목적임
        List<Integer> answer = new ArrayList<>();
        int change[] = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for(int i = 0; i < change.length; i++) {
            Integer a = money/change[i];
            answer.add(a);
            money %= change[i];
        }
        return answer;
    }
}
