package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {

    public static boolean validCheck(int money) {
        return money >= 1 && money <= 1000000;
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        if(!validCheck(money)){
            throw new IllegalStateException("잘못된 입력입니다.");
        }
        return answer;
    }
}
