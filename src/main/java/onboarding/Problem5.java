package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = moneyList(money);
        return answer;
    }

    private static List<Integer> moneyList(int money){
        List<Integer> result = new ArrayList<>();

        // money는 1 이상 1,000,000 이하인 자연수이다.
        if (1 > money || 1000000 < money) {
            return null;
        }

        return result;
    }
}
