package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList();

        answer.add(0, money / 50000);
        money = money % 50000;
        answer.add(1, money / 10000);
        money = money % 10000;
        answer.add(2, money / 5000);
        money = money % 5000;
        answer.add(3, money / 1000);
        money = money % 1000;
        answer.add(4, money / 500);
        money = money % 500;
        answer.add(5, money / 100);
        money = money % 100;
        answer.add(6, money / 50);
        money = money % 50;
        answer.add(7, money / 10);
        money = money % 10;
        answer.add(8, money);
        money = money % 1;

        return answer;
    }
}
