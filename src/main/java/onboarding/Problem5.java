package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(Collections.emptyList());
        int count = 0;
        int tmp = money;

        count = tmp / 50000;
        answer.add(count);
        tmp -= tmp/50000 * 50000;

        count = tmp / 10000;
        answer.add(count);
        tmp -= tmp/10000 * 10000;

        count = tmp / 5000;
        answer.add(count);
        tmp -= tmp/5000 * 5000;

        count = tmp / 1000;
        answer.add(count);
        tmp -= tmp/1000 * 1000;

        count = tmp / 500;
        answer.add(count);
        tmp -= tmp/500 * 500;

        count = tmp / 100;
        answer.add(count);
        tmp -= tmp/100 * 100;

        count = tmp / 50;
        answer.add(count);
        tmp -= tmp/50 * 50;

        count = tmp / 10;
        answer.add(count);
        tmp -= tmp/10 * 10;

        count = tmp;
        answer.add(count);

        return answer;
    }
}
