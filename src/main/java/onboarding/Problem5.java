package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        answer.add((money/10000)/5);
        answer.add((money/10000)%5);
        money = money % 10000;

        answer.add((money/1000)/5);
        answer.add((money/1000)%5);
        money = money % 1000;

        answer.add((money/100)/5);
        answer.add((money/100)%5);
        money = money % 100;

        answer.add((money/10)/5);
        answer.add((money/10)%5);
        money = money % 10;
        
        answer.add(money);

        return answer;
    }
}
