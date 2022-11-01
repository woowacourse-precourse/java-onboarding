package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {

        // 예외 처리
        if (money < 1 || money > 1000000) {
            return Collections.emptyList();
        }

        List<Integer> answer = new ArrayList<>(Collections.nCopies(9, 0));

        // 50000원
        answer.set(0, money / 50000);
        money %= 50000;

        // 10000원
        answer.set(1, money / 10000);
        money %= 10000;

        // 5000원
        answer.set(2, money / 5000);
        money %= 5000;

        // 1000원
        answer.set(3, money / 1000);
        money %= 1000;

        // 500원
        answer.set(4, money / 500);
        money %= 500;

        // 100원
        answer.set(5, money / 100);
        money %= 100;

        // 50원
        answer.set(6, money / 50);
        money %= 50;

        // 10원
        answer.set(7, money / 10);
        money %= 10;

        // 1원
        answer.set(8, money);

        return answer;
    }
}
