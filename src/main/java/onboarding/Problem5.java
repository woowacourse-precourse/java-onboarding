package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
                //Collections.emptyList();

        int m500, m100, m50, m10, m5, m1, m05, m01, m001;

        m500 = money/50000;
        answer.add(m500);
        money = money%50000;

        m100 = money/10000;
        answer.add(m100);
        money = money%10000;

        m50 = money/5000;
        answer.add(m50);
        money = money%5000;

        m10 = money/1000;
        answer.add(m10);
        money = money%1000;

        m5 = money/500;
        answer.add(m5);
        money = money%500;

        m1 = money/100;
        answer.add(m1);
        money = money%100;

        m05 = money/50;
        answer.add(m05);
        money = money%50;

        m01 = money/10;
        answer.add(m01);
        money = money%10;

        m001 = money;
        answer.add(m001);

        return answer;
    }
}
