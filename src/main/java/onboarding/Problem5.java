package onboarding;

import java.util.ArrayList;

import java.util.List;

public class Problem5 {
    public static List<Integer> result(int money){
        List<Integer> result = new ArrayList<>();
        result.add(0, money/50000);
        money = money%50000;
        result.add(1,money/10000);
        money = money%10000;
        result.add(2,money/5000);
        money = money%5000;
        result.add(3,money/1000);
        money = money%1000;
        result.add(4,money/500);
        money = money%500;
        result.add(5,money/100);
        money = money%100;
        result.add(6,money/50);
        money = money%50;
        result.add(7,money/10);
        money = money%10;
        result.add(8,money);//마지막은 1원이기때문에 다른연산없이 바로넣어준다.
        return result;
    }
    public static List<Integer> solution(int money) {
        List<Integer> result = result(money);

        return result;
    }
}
