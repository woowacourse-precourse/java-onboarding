package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 구현해야할 기능
 * [50000, 10000, 5000, 1000, 500, 100, 50, 10, 1]
 * 5만원부터 시작하여 나눈 몫을 리스트에 차례대로 담는다.
 */
public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();
        int[] won = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int i = 0; i < won.length; i++) {
            int count = money / won[i];
            answer.add(count);
            money %= won[i];
        }

        return answer;
    }
}
