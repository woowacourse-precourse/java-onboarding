package onboarding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {

        List<Integer> answer = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0);

        int num = money/50000;
        money %= 50000;
        answer.set(0, num);

        num = money/10000;
        money %= 10000;
        answer.set(1, num);

        num = money/5000;
        money %= 5000;
        answer.set(2, num);

        num = money/1000;
        money %= 1000;
        answer.set(3, num);

        num = money/500;
        money %= 500;
        answer.set(4, num);

        num = money/100;
        money %= 100;
        answer.set(5, num);

        num = money/50;
        money %= 50;
        answer.set(6, num);

        num = money/10;
        money %= 10;
        answer.set(7, num);

        answer.set(8, money);

        return answer;
    }
}
