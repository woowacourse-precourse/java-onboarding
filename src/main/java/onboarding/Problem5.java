package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        List<Integer> answer2 = new ArrayList<>();
        answer2.add(0,money/50000);
        money%=50000;
        answer2.add(1,money/10000);
        money%=10000;
        answer2.add(2,money/5000);
        money%=5000;
        answer2.add(3,money/1000);
        money%=1000;
        answer2.add(4,money/500);
        money%=500;
        answer2.add(5,money/100);
        money%=100;
        answer2.add(6,money/50);
        money%=50;
        answer2.add(7,money/10);
        money%=10;
        answer2.add(8, money);
        answer = answer2;
        return answer;
    }
}
