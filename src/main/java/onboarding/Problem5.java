package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        int cnt = 0;
        int[] moneyType = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        answer = new ArrayList<>();
        // 1. 화폐 단위별로 금액 나누기
        for (int i = 0; i < moneyType.length; i++) {
            cnt = money / moneyType[i];
            money %= moneyType[i];
            answer.add(cnt);
        }
        return answer;
    }
}
