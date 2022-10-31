package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        if (isException(money)) throw new RuntimeException("잘못된 인자입니다.");
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    private static Boolean isException(int number) {
        return number < 1 || number > 1000000;
    }
}
