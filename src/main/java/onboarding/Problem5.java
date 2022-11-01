package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * [o] money를 최대한 가볍도록 큰 금액의 화폐 위주로 받는 배열을 만든다.
 */
public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        answer = getTypeOfMoney(answer,money);
        return answer;
    }

    public static List<Integer> getTypeOfMoney(List<Integer> answer, int money) {
        int[] types = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int current = money;

        for (int i = 0; i < types.length; i++) {
            int type = types[i];
            int cnt = current / type;
            answer.add(cnt);
            current %= type;
        }
        return answer;
    }
}
