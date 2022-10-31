package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        if(isValid(money)){
            List<Integer> answer = Collections.emptyList();
            return answer;
        }else
            return null;
    }

    static boolean isValid(int money) {
        return money >= 1 && money <= 1000000;
    }
}
