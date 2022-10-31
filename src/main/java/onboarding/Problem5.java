package onboarding;


import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    public static List<Integer> solution(int money) {
        List<Integer> result = new ArrayList<>();
        int money_50000, money_10000, money_5000, money_1000, money_500, money_100, money_50, money_10, money_1,  tmp;

        money_50000 = money / 50000;
        tmp = money - money_50000 * 50000;
        result.add(money_50000);

        money_10000 = tmp / 10000;
        tmp = tmp - money_10000 * 10000;
        result.add(money_10000);

        money_5000 = tmp / 5000;
        tmp = tmp - money_5000 * 5000;
        result.add(money_5000);

        money_1000 = tmp / 1000;
        tmp = tmp - money_1000 * 1000;
        result.add(money_1000);

        money_500 = tmp / 500;
        tmp = tmp - money_500 * 500;
        result.add(money_500);

        money_100 = tmp / 100;
        tmp = tmp - money_100 * 100;
        result.add(money_100);

        money_50 = tmp / 50;
        tmp = tmp - money_50 * 50;
        result.add(money_50);

        money_10 = tmp / 10;
        tmp = tmp - money_10 * 10;
        result.add(money_10);

        money_1 = tmp / 1;
        result.add(money_1);

        return result;
    }
}
