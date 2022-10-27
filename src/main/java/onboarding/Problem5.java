package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        if (checkInput(money)) {
            answer.add(-1);
            return answer;
        }

        return answer;
    }

    public static boolean checkInput(int money) {
        if (money < 1 || money > 1000001) {
            return true;
        }
        return false;
    }
}
