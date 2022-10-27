package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        answer.add(0, money / 50000);
        money=money-((money/50000)*50000);//5만원
        answer.add(1, money / 10000);
        money=money-((money/10000)*10000);//만원
        answer.add(2, money / 5000);
        money=money-((money/5000)*5000);//5천원
        answer.add(3, money / 1000);
        money=money-((money/1000)*1000);//천원
        answer.add(4, money /500);
        money=money-((money/500)*500);//오백원
        answer.add(5, money / 100);
        money=money-((money/100)*100);//백원
        answer.add(6, money / 50);
        money=money-((money/50)*50);//오십원
        answer.add(7, money / 10);
        money=money-((money/10)*10);//십원
        answer.add(8, money / 1);
        money=money-((money/1)*1);//일원
        return answer;
    }
}
