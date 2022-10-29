package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        if (checkValidation(money)) {

        }

        return answer;
    }

    private static boolean checkValidation(int inputValue) {
        // 1 이상 1,000,000 이하의 자연수인지 확인하다.
        if (!(1 <= inputValue && inputValue <= 1_000_000)) {
            return false;
        }

        return true;
    }
}
