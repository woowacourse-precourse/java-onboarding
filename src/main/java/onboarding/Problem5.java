package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1. 알맞은 화폐로 변환한 수를 구하는 기능
 */
public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] money_type = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int type : money_type) {
            answer.add(money / type);
            money %= type;
        }

        return answer;
    }
}
