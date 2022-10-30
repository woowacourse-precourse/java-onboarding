package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        // 화폐 단위 선언
        int[] bill = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
        int cnt = 0;

        // 화폐 단위가 큰 순서대로 money를 차감
        for (int i = 0; i < bill.length; i++) {
            cnt = money / bill[i];
            answer.add(cnt);
            money -= (cnt * bill[i]);
        }

        // 남은 money는 1원 단위이기 때문에 마지막에 add
        answer.add(money);

        return answer;
    }
}
