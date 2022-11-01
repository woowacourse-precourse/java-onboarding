package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {

        int answer_0 = money / 50000;
        money %= 50000;
        int answer_1 = money / 10000;
        money %= 10000;
        int answer_2 = money / 5000;
        money %= 5000;
        int answer_3 = money / 1000;
        money %= 1000;
        int answer_4 = money / 500;
        money %= 500;
        int answer_5 = money / 100;
        money %= 100;
        int answer_6 = money / 50;
        money %= 50;
        int answer_7 = money / 10;
        money %= 10;
        int answer_8 = money;
        List<Integer> answer = List.of(answer_0, answer_1, answer_2, answer_3, answer_4, answer_5, answer_6,
                answer_7, answer_8);
        return answer;
    }
}
