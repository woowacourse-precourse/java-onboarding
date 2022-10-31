package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int a = money / 50000;
        money = money - a * 50000;
        int b = money / 10000;
        money = money - b * 10000;
        int c = money / 5000;
        money = money - 5000 * c;
        int d = money / 1000;
        money = money - 1000 * d;
        int e = money / 500;
        money = money - 500 * e;
        int f = money / 100;
        money = money - 100 * f;
        int g = money / 50;
        money = money - 50 * g;
        int h = money / 10;
        int i = money % 10;
        answer.add(a);
        answer.add(b);
        answer.add(c);
        answer.add(d);
        answer.add(e);
        answer.add(f);
        answer.add(g);
        answer.add(h);
        answer.add(i);
        return answer;
    }
}
