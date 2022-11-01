package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();

        int m, m1, m2, m3, m4, m5, m6, m7, m8, m9;

        m1 = money / 50000;
        money = money - m1 * 50000;

        m2 = money / 10000;
        money = money - m2 * 10000;

        m3 = money / 5000;
        money = money - m3 * 5000;

        m4 = money / 1000;
        money = money - m4 * 1000;

        m5 = money / 500;
        money = money - m5 * 500;

        m6 = money / 100;
        money = money - m6 * 100;

        m7 = money / 50;
        money = money - m7 * 50;

        m8 = money / 10;
        money = money - m8 * 10;

        m9 = money / 1;
        money = money - m9 * 1;

        answer.add(0, m1);
        answer.add(1, m2);
        answer.add(2, m3);
        answer.add(3, m4);
        answer.add(4, m5);
        answer.add(5, m6);
        answer.add(6, m7);
        answer.add(7, m8);
        answer.add(8, m9);

        return answer;
    }
}
