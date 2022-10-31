package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        //List<Integer> answer = Collections.emptyList();
        // 메모리 절약, 빈 값 반환, 안전성
        List<Integer> answer = new ArrayList<>();
        answer.add(money/50000);
        money = money - (money/50000)*50000;
        answer.add(money/10000);
        money = money - (money/10000)*10000;
        answer.add(money/5000);
        money = money - (money/5000)*5000;
        answer.add(money/1000);
        money = money - (money/1000)*1000;
        answer.add(money/500);
        money = money - (money/500)*500;
        answer.add(money/100);
        money = money - (money/100)*100;
        answer.add(money/50);
        money = money - (money/50)*50;
        answer.add(money/10);
        answer.add(money - (money/10)*10);
        return answer;
    }
}
