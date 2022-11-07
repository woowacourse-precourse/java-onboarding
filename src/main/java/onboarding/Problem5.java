package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> moneyUnit = new ArrayList<Integer>(){{  // 선언과 동시에 초기화
            add(50000);
            add(10000);
            add(5000);
            add(1000);
            add(500);
            add(100);
            add(50);
            add(10);
            add(1);
        }};

        for(Integer unit : moneyUnit) {
            if (money < unit) {  // unit이 money보다 클 경우엔 answer에 0을 넣어주면서 continue
                answer.add(Integer.valueOf(0));
                continue;
            }

            answer.add(Integer.valueOf(money / unit)); // 몫(몇개로 나눠지는지)를 넣어줌.
            money = money % unit;
        }

        return answer;
    }
}
