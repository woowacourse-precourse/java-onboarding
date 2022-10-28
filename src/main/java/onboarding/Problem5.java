package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        if (!isValidate(money)) {
            ArrayList<Integer> error = new ArrayList<>();
            error.add(-1);
            return error;
        }
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    /**
     * 제한사항 검증하는 기능
     */
    public static boolean isValidate(int money) {
        return (money > 0 && money < 1_000_001);
    }
}
