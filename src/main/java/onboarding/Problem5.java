package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static void checkMoney(int money){
        if(money>1000000||money<1)
            throw new IllegalArgumentException("올바른 범위가 아닌 입력값입니다.");
    }

    public static List<Integer> solution(int money) {
        checkMoney(money);
        List<Integer> answer = Collections.emptyList();
        return answer;
    }
}
