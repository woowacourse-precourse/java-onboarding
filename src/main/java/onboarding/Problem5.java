package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] check_money = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        boolean account = validation(money);
        if (!account) {
            return answer;
        }
        //큰 금액별로 나누고 나머지 넘기기
        for(int i = 0; i < check_money.length; i++) {
            if (i == 0) {
                answer.add(money / check_money[i]);
            } else {
                answer.add((money % check_money[i - 1]) / check_money[i]);
           }
        }
        return answer;
    }

    private static boolean validation(int num) {
        // 1미만, 1000000 초과
        if(num < 1 || num > 1000000) {
            return false;
        }
        return true;
    }
}
