package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        // 각 단위가 서로 배수이므로 큰 값부터 나누고 money에 반영해주면 된다.
        for(int i = 0; i < unit.length; i++) {
            answer.add(money / unit[i]);
            money %= unit[i];
        }

        return answer;
    }
}
