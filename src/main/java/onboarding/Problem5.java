package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        final List<Integer> ERROR = Collections.emptyList();
        if (violation(money)) return ERROR;
        List<Integer> answer = new ArrayList<>(9);
        List<Integer> coins = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        // 비싼 화폐부터 채우는 것이 최적(뒤에 나오는 값이 앞에 나오는 값의 약수이기 때문)
        for (int coin : coins) {
            answer.add(money / coin);
            money %= coin;
        }
        return answer;
    }
    
    // 돈의 액수가 올바른 입력인지 체크
    static boolean violation(int money) {
        return money <= 0 || money > 1000000;
    }
}
