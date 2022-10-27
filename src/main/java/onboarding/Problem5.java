package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    static int change(int m, int div_m){
        return m/div_m;
    }

    static List<Integer> withdrow(int money){
        List<Integer> answer = new ArrayList<>(Collections.emptyList());
        answer.add(change(money, 50000));
        money %= 50000;
        answer.add(change(money, 10000));
        money %= 10000;
        answer.add(change(money, 5000));
        money %= 5000;
        answer.add(change(money, 1000));
        money %= 1000;
        answer.add(change(money, 500));
        money %= 500;
        answer.add(change(money, 100));
        money %= 100;
        answer.add(change(money, 50));
        money %= 50;
        answer.add(change(money, 10));
        money %= 10;
        answer.add(change(money, 1));
//        System.out.println(answer);
        return answer;
    }

    public static List<Integer> solution(int money) {
        return withdrow(money);
    }
}
