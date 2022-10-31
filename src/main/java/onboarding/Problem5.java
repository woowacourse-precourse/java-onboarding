package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        /* 화폐 단위별 개수 리스트 초기화 */
        List<Integer> cnt = new ArrayList<>(9);
        for(int i = 0; i < 9; i++) {
            cnt.add(0);
        }

        for(int i = 0; i < unit.length; i++) {
            if(money <= 0) {
                break;
            }
            int quotient = money / unit[i];
            if(quotient > 0) {
                money %= unit[i];
                cnt.set(i, quotient);
            }
        }
        answer = cnt;
        return answer;
    }
}
