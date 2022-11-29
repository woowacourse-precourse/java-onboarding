package onboarding;

import java.util.ArrayList;
import java.util.List;


public class Problem5 {

    public static List<Integer> solution(int money) {
        return checkTheTotalNumberOfTimes(money);
    }

    private static List<Integer> checkTheTotalNumberOfTimes(int money) {
        List<Integer> countList = new ArrayList<>();
        int[] currencies = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int currency : currencies) {
            countList.add(money / currency);
            money = money % currency;
        }
        return countList;
    }
}
