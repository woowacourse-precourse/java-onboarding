package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        //5만원권
        answer.add(money / 50000);
        money = money % 50000;
        //1만원권
        answer.add(money / 10000);
        money = money % 10000;
        //5천원권
        answer.add(money / 5000);
        money = money % 5000;
        //1천원권
        answer.add(money / 1000);
        money = money % 1000;
        //500원권
        answer.add(money / 500);
        money = money % 500;
        //100원권
        answer.add(money / 100);
        money = money % 100;
        //50원권
        answer.add(money / 50);
        money = money % 50;
        //10원권
        answer.add(money / 10);
        money = money % 10;
        //1원권
        answer.add(money);

        return answer;
    }
}
