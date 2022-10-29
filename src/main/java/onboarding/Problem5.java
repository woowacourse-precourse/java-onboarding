package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        if (throwBoundaryException(money)) {
            return Collections.emptyList();
        }
        
        return answer;
    }

    public static boolean throwBoundaryException(int money) {
        return money < 1 || money > 1000000;
    }
}
