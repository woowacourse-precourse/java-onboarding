package onboarding.problem5;

import java.util.List;

public class Calculator {
    public List<Integer> func(List<Integer> answer, int money){
        answer.add(0, money / 50000);
        money %= 50000;
        answer.add(1,money / 10000);
        money %= 10000;
        answer.add(2,money / 5000);
        money %= 5000;
        answer.add(3,money / 1000);
        money %= 1000;
        answer.add(4,money / 500);
        money %= 500;
        answer.add(5,money / 100);
        money %= 100;
        answer.add(6,money / 50);
        money %= 50;
        answer.add(7,money / 10);
        money %= 10;
        answer.add(8,money / 1);
        return answer;
    }
}
